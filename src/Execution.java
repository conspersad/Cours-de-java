import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.System;
import java.lang.String;
public class Execution {
    static Scanner scanner = new Scanner(System.in);
    static Wizard wizard;
    static Pet pet;
    static Wand wand;
    static House house;
    static int maxHp=100;
    static int xp=0;
    public static int place =0,level=1;
    public static String[] places ={"The philosopher's stone","The chamber of secret","The prisonner of azkaban", "the goblet of fire","The order of the phenix","The half-blood prince","The deathly Hallows"};
    public static boolean isRunning;
    private static int encounter;

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
        int size = 0;
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

        wizard = new Wizard(name, Pet.choosePet(),Wand.choose_wand() ,House.your_house(), maxHp, xp); //appel de joueuer

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
   public static void rendomEncounter(){
        int encounter =(int) (Math.random()*encounter.length);
        if(encounter[encounter].equals("Battle")){

        }else if(encounter[encounter].equals("Rest")){

        }else{

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
    public static void battle(Enemy enemy){
        while(true)
            clearconsole();
        printHeading(enemy.name +"\nHP: " +enemy.hp +"/" + enemy.maxHp );
        printHeading(wizard.name +"\nHP: " + wizard.hp +"/"+wizard.maxHp);
        System.out.println("Choose an action :");
        printseperator(20);
        System.out.println("(1) Fight\n(2) Use Potion \n(3) Run away");
        int input = readInt("->",3);
        if(input==1){
            //calculate dmg and dmgTook
            int dmg = wizard.attack() - enemy.defend();
            int dmgTook= enemy.attack()- wizard.defend();
            if(dmgTook < 0){
                dmg -= dmgTook/2;
                dmgTook=0;
            }if(dmg< 0) {
                dmg = 0;
                wizard.hp -= dmgTook;
                enemy.hp -= dmg;
                clearconsole();
                printHeading("Battle");
                System.out.println("You dealt" + dmg + "damage to the " + enemy.name);
                printseperator(15);
                System.out.println("The" + enemy.name + "dealt " + dmgTook + "damage to you");
                //check if player is still alive or dead
                if (wizard.hp <= 0) {
                    wizardDied();

                } else if (enemy.hp <= 0) {
                    clearconsole();
                    printHeading("You defeated the" + enemy.name + "!");
                    wizard.xp += enemy.xp;
                    System.out.println("You earned" + enemy.xp + "XP !");
                    anythingtocontinue();
                    }}
                 else if(input == 2){
                     //next part
                }else{
                     clearconsole();
                     if(Math.random()*10+1<=3.5){
                         printHeading("You ran away from the "+ enemy.name +"!");
                         anythingtocontinue();

                     }else {
                         printHeading("You didn't manage to escape");
                         dmgTook = enemy.attack();
                         System.out.println("In your hurry you took 0 " + dmgTook + "damage !");
                         anythingtocontinue();
                         if (wizard.hp <= 0)
                             wizardDied();
                     }}}}
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




