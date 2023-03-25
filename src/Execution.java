import java.util.Scanner;
import java.lang.System;
import java.lang.String;
public class Execution {
    static Scanner scanner = new Scanner(System.in);
    static Wizard wizard;
    static Enemy enemy;

    static int maxHp=100;
    static int xp=0;
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
                System.out.println("entrer un nombre entier !");
            }
        } while (input < 1 || input > Userchoice);
        return input;
    }

    //methode pour commencer le jeu
    public static void startGame(){
        boolean nameSet = false;
        String name;
        // print title screen
        clearconsole();
        printseperator(10);
        System.out.println("Harry Potter");
        System.out.println("BY CONSTANCE PERSAD");
        printseperator(10);
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

        wizard = new Wizard(name, Pet.choosePet(),Wand.choose_wand() ,House.your_house(), maxHp=100, xp); //appel de joueuer

        //setting isRunning to true so the game loop can continue
        isRunning =true;

        //start main game loop
        gameLoop();

        }
        //method to continue the journey
   public static void checkAct(){
        if( Character.xp <= 10 && level==1){
        level=2;
        place=1;
            //on appele les intro des niveaux1
            Story.Thephilosopherstone_Intro();
            enemy = new Enemy("Troll",50,10);
            battle();
            Story.Thephilosopherstone_Outro();

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
        Spell spell = new Spell(Execution.level,Spell.CastSpeel(), new String[]{Spell.knownSpells[level]});
       // Boucle principale du jeu
       while (wizard.isAlive() && enemy.isAlive()) {
           // Tour du sorcier
           System.out.println(wizard.name + " (" + wizard.hp + " PV, " + wizard.xp + " DEF) vs " + enemy.name + " (" + enemy.hp + " PV, " + enemy.xp + " DEF)");
           System.out.println("Que voulez-vous faire ?");
           System.out.println("1 - Attaquer");
           System.out.println("2 - Utiliser une potion");
           System.out.println("3 - Se défendre");
           int choice = scanner.nextInt();
           switch (choice) {
               case 1:
                   int damage = wizard.attack();
                   int reducedDamage = enemy.defend();
                   enemy.maxHp = maxHp - reducedDamage;
                   System.out.println(wizard.name + " inflige " + damage + " points de dégâts. L'ennemi subit " + reducedDamage + " points de dégâts.");
                   break;
               case 2:
                   wizard.usePotion();
                   break;
               case 3:
                   wizard.defend();
                   System.out.println(wizard.name+ " se met en position défensive.");
                   break;
               default:
                   System.out.println("Choix invalide.");
                   break;
           }
           // Tour de l'ennemi
           if (enemy.isAlive()) {
               int damage = enemy.attack();
               int reducedDamage = wizard.defend();
               wizard.maxHp=maxHp-reducedDamage;

               System.out.println(enemy.name + " inflige " + damage + " points de dégâts. " + wizard.name + " subit " + reducedDamage + " points de dégâts.");
           }
       }
       // Fin du jeu
       if (wizard.isAlive()) {
           System.out.println(wizard.name+ " a vaincu " + enemy.name + " !");
       } else {
           System.out.println(enemy.name + " a vaincu " + wizard.name + " !");
       }
   }


    public static void continueJourney(){
        //check if game isn't in last act
        if(level != 7)checkAct();
            //rendomEncounter();
    }
    public static void TrollBattle(){
        System.out.println("You encountered a troll in the toilette. You'll have to fight it");
    }

    public static void wizardDied(){
        clearconsole();
        printHeading("You died...");
        printHeading("You earned " + wizard.xp + " XP on your journey.Try to earn more next time!");
    }
    //printing out the most important information about the payer charcter
    public static void characterInfo(){
        clearconsole();
        printHeading("Character info");
        System.out.println(wizard.name + "Your Pet : " + wizard.pet + "\n The size of your wand : " + wizard.wand + "\n : Your house is :" + wizard.house);
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
        • Les potions sont plus efficaces pour les membres de Hufflepuff.
        • Les sorts font plus de dégâts pour les membres de Slytherin.
        • Les sorciers de Gryffindor sont plus résistants aux dégâts.
        • Les sorciers de Ravenclaw sont plus précis*/




