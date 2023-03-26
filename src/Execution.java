import java.util.Scanner;
import java.lang.System;
import java.lang.String;
public class Execution {
    static Scanner scanner = new Scanner(System.in);
    static Wizard wizard;
    static Enemy enemy;
    static Spell speel;

    public static int place =0,level=1;
    public static String[] places ={"The philosopher's stone","The chamber of secret","The prisonner of azkaban", "the goblet of fire","The order of the phenix","The half-blood prince","The deathly Hallows"};

    public static boolean isRunning;



    public static void printseperator(int n){
        for(int i=0;i<n;i++)
        System.out.print("-");
        System.out.println();
    }
    public static void printHeading(String title){
        printseperator(30);
        System.out.println(title);
        printseperator(30);}
    public static void anythingtocontinue(){
        System.out.println("\nEnter something to continue...");
        scanner.next();}
    public static void clearconsole(){
        for(int i=0; i<5;i++)
            System.out.println();
    }
    public static int readInt(String prompt, int Userchoice) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e){
                input = -1;
                System.out.println("entrer a number !");
            }
        } while (input < 1 || input > Userchoice);
        return input;
    }

    //methode pour commencer le jeu
    public static void startGame(){
        int xp;
        boolean nameSet = false;
        String name;
        // print title screen
        clearconsole();
        printseperator(20);
        System.out.println("Harry Potter");
        System.out.println("BY CONSTANCE PERSAD");
        printseperator(20);
        anythingtocontinue();

        do {
            clearconsole();
            printHeading("What's your name ?");
            name = scanner.next();
            //asking the player if he want to correct his choice
            clearconsole();
            printHeading("Your name is " + name + ".\nIs that correct ?");
            System.out.println("(1) Yes !");
            System.out.println("(2) No i want to change my name !");
            int input = readInt("->", 2);
            if (input == 1)
                nameSet = true;
        }while(!nameSet);

        Story.printIntro();

        Execution.anythingtocontinue();

        wizard = new Wizard(name, Pet.choosePet(),Wand.choose_wand() ,House.your_house(), 100, xp=0); //appel de joueuer

        //setting isRunning to true so the game loop can continue
        isRunning =true;

        //start main game loop
        gameLoop();

        }
        //method to continue the journey
   public static  void checkAct(){
        if( Character.xp >=0  && level==1){
            int maxHp=50,xp= 10;
            //on appele les intro des niveaux1
            Story.Thephilosopherstone_Intro();
            enemy = new Enemy("Troll",xp,maxHp);
            speel = new Spell(1, 10, new String[] {"Wingardium Leviosa"});
            battle();
            Story.Thephilosopherstone_Outro();
            level=2;
            place=1;

        }else if( (Character.xp >= 10 && Character.xp <= 20) && level==2){
            level=3;
            place=2;

        }else if((Character.xp >=20 && Character.xp <=30) && level==3){
            level=4;
            place=3;

        }else if((Character.xp >= 30 && Character.xp <=50) && level==4){
            level=5;
            place=4;

        }else if((Character.xp >= 50 && Character.xp <=70) &&level==5){
            level=6;
            place=5;

        }else if((Character.xp >= 70 && Character.xp <=90) &&level==6){
            level=7;
            place=6;

        }
   }
    public static void battle(){
       // Boucle principale du jeu
       while (wizard.isAlive() && enemy.isAlive()) {
          wizard.xp=Spell.damage;
           // Tour du sorcier
           System.out.println(wizard.name + " (" + Wizard.hp + " hp, " + wizard.xp + " Xp) vs " + enemy.name + " (" + enemy.hp + " hp, " + enemy.xp + " xp)");
           System.out.println("What do you want to do ?");
           System.out.println("1 - fight "+enemy.name);
           System.out.println("2 - Use a sort to have more Hp");
           System.out.println("3 - Leave");
           int choice = scanner.nextInt();
           switch (choice) {
               case 1 -> {
                   int damage = wizard.attack();
                   int reducedDamage = enemy.defend();
                   int totalDamage = reducedDamage * damage;
                   enemy.setHp(enemy.hp - totalDamage);
                   System.out.println(wizard.name + " use Wingardium Leviosas, inflicting " + damage + " damage points.");
                   if(totalDamage==0){
                       System.out.println(enemy.name + " dodge your attack, so he didn't took " + damage + " damage points.");
                   }else
                       System.out.println(Execution.enemy.name + " was hit!");

               }
               case 2 -> {System.out.println(Execution.wizard.name +" you only have "+ wizard.nbr_de_potion +" left !");
                       wizard.usePotion();}
               case 3 -> {
                   System.out.println(wizard.name + " leave");
                   System.out.println("You are eather very smart or eather a little bit coward");
                   gameLoop();
               }
               default -> System.out.println("Choix invalide.");
           }
           // Tour de l'ennemi
           if (enemy.isAlive()) {
               int damage = enemy.attack();
               int reducedDamage = wizard.defend();
               int totalDamage = reducedDamage * damage;
               wizard.setHp(wizard.hp - totalDamage);
               System.out.println(enemy.name + " attack causing " + damage + " damage points. " + wizard.name + " take " + totalDamage + " damage points.");
           }
       }
       // Fin du jeu
       if (wizard.isAlive()) {
           System.out.println(wizard.name+ " defeat " + enemy.name + " !");
       } else {
           System.out.println(enemy.name + " defeat " + wizard.name + " !");
           wizardDied();
       }
   }


    public static void continueJourney(){
        //check if game isn't in last act
        if(level != 7)checkAct();
            //rendomEncounter();
    }

    public static void wizardDied(){
        clearconsole();
        printHeading("You died...");
        printHeading("You earned " + wizard.xp + " XP on your journey.Try to earn more next time!");
        isRunning=false;
    }
    //printing out the most important information about the payer charcter
    public static void characterInfo(){
        clearconsole();
        printHeading("Character info");
        System.out.println(wizard.name + "Your Pet : " + wizard.pet + "\nThe size of your wand : " + wizard.wand + "\nYour house is :" + wizard.house);
        printseperator(5);
    }
    public static void printMenu(){
        clearconsole();
        printHeading(places[place]);
        System.out.println("choose an action:");
        printseperator(20);
        System.out.println("(1) Continue your journey");
        System.out.println("(2) Character info");
        System.out.println("(3) Exit game");

    }
    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("->",3);
            if(input==1)
                continueJourney();
            else if(input==2)
                characterInfo();
            else
                isRunning=false;
        }
    }


    }
   /* À chaque niveau,
        vous allez affronter des ennemis différents. Les mécaniques pour les vaincre changeront en fonction
        de l’ennemi.
        Pour combattre vos ennemis, vous pourrez utiliser des sorts (Spell) que vous apprendez au fur
        et à mesure des années. Vous disposez également de potions (Potion) qui peuvent vous aider à
        regagner de la vie. Les sorts que vous lancez ont un pourcentage de chance de réussite : vous pouvez
        rater vos sorts.
        Lorsque vous gagnez un combat, vous pouvez choisir d’augmenter vos points de vie, vos points
        de dégâts.
        Chaque maison a sa spécificité :
        • Les sorts font plus de dégâts pour les membres de Slytherin.
        • Les sorciers de Gryffindor sont plus résistants aux dégâts.
        • Les sorciers de Ravenclaw sont plus précis*/




