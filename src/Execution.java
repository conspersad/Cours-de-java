import java.util.Scanner;
import java.lang.System;
import java.lang.String;



public class Execution {
    static Scanner scanner = new Scanner(System.in);
    static Wizard wizard;
    static Enemy enemy,enemy1;
    static Spell spell;
    public static int speel;
    public static int place =0,level=1;
    public static String[] places ={"The philosopher's stone","The chamber of secret","The prisoner of azkaban", "the goblet of fire","The order of the phoenix","The half-blood prince","The deathly Hallows"};

    public static boolean isRunning;



    public static void printseperator(int n){
        for(int i=0;i<n;i++) {
            System.out.print("-");
        }
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
                System.out.println("enter a number !");
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
        printseperator(20);
        System.out.println("Harry Potter");
        System.out.println("BY CONSTANCE PERSAD");
        printseperator(20);
        anythingtocontinue();

        do {
            clearconsole();
            printHeading("What's your name ?");
            name = scanner.next();
            //asking the player if he wants to correct his choice
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

        wizard = new Wizard(name, Pet.choosePet(),Wand.choose_wand() ,House.your_house(), 100, 0); //appel de joueuer

        //setting isRunning to true so the game loop can continue
        isRunning =true;

        //start main game loop
        gameLoop();

        }
        //method to continue the journey
   public static  void checkAct(){
        if( Character.xp >=0  && level==1){
            int xp;
            //on appele les intro des niveaux1
            Story.Thephilosopherstone_Intro();
            enemy = new Enemy("Troll", 10, 30);
            spell = new Spell(1, 10, new String[] {"Wingardium Leviosa"});
            battle();
            Story.Thephilosopherstone_Outro();
            clearconsole();
            anythingtocontinue();
            level=2;
            place=1;
            gameLoop();

        }else if( (Character.xp >= 10 || Character.xp <= 20) && level==2){
            Story.TheChamberOfSecret_Intro();
            enemy1 = new Enemy("Basilic", 30,60 );
            spell = new Spell(1, 10, new String[] {"Accio"});
            battle();
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
           String message ="What do you want to do ?\n"+
           "1 - fight "+enemy.name+" !\n" +
           "2 - Use a sort to have more Hp (only if your life is < 100)\n"
           +"3 - Leave";
           slowPrint(message,75);
           int choice = scanner.nextInt();
           switch (choice) {
               case 1 -> {
                   System.out.println("You need to choose a Spell");
                   for (int i = 0; i < Spell.knownSpells.length; i++) {
                       System.out.println( "Press "+i + " to use : " + Spell.knownSpells[i]);
                   }
                   int speel = scanner.nextInt();
                   Spell.getDamage(speel);
                   int damage = wizard.attack();
                   int reducedDamage = enemy.defend();
                   int totalDamage = reducedDamage * damage;
                   enemy.setHp(enemy.hp - totalDamage);
                   String message1 = wizard.name + " use Wingardium Leviosas, inflicting " + damage + " damage points\n";
                   slowPrint(message1,75);
                   if(totalDamage==0){
                   String message2= enemy.name + " dodge your attack\n";
                       slowPrint(message2,75);
                   }else {
                       String message3= Execution.enemy.name + " was hit!\n";
                       slowPrint(message3,75);
                   }

               }
               case 2 -> {
                   if((Execution.wizard.house=="Hufflepuff")&&(Execution.wizard.hp<100))
               {
                   int healed = 20;
                   wizard.setHp(wizard.hp+healed);
                   System.out.println("You healed "+ healed+" Hp !\n");
                  wizard.nbr_de_potion=wizard.nbr_de_potion-1;

                  }else if((Execution.wizard.house!="Hufflepuff")&&(Execution.wizard.hp<100)){

                       int healed = 10;
                       System.out.println("You healed "+ healed+" Hp !\n");
                       wizard.setHp(Wizard.hp +healed);
                       wizard.nbr_de_potion=wizard.nbr_de_potion-1;

                   }  else if (Execution.wizard.hp>=100) {
                       System.out.println("You have enough hp\n");
                   }
               }

                   case 3 -> {
                   System.out.println(wizard.name + " leave");
                   System.out.println("You are either very smart or either a little bit coward");
                   gameLoop();
               }
               default -> {
                   System.out.println("Choice not valid");
               }
           }

           if (enemy.isAlive()) {
               int damage = enemy.attack();
               int reducedDamage = wizard.defend();
               int totalDamage = reducedDamage * damage;
               wizard.setHp(wizard.hp - totalDamage);
               String message4 = enemy.name + " attack causing " + damage + " damage points. \n"
                       + wizard.name + " take " + totalDamage + " damage points.\n";
               slowPrint(message4,75);
           }
       }
       // Fin du jeu
       if (wizard.isAlive()) {
           String message5 = wizard.name+ " defeat " + enemy.name + " !\n";
           slowPrint(message5,25);
       } else {
           String message6= enemy.name + " defeat " + wizard.name + " !\n";
           slowPrint(message6,25);
           wizardDied();
       }
   }

    public static void slowPrint(String message, int delay) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(); //
    }

    public static void continueJourney(){
        //check if game isn't in last act
        if(level != 7)checkAct();

    }

    public static void wizardDied(){
        clearconsole();
        printHeading("You died...");
        printHeading("You earned " + wizard.xp + " XP on your journey.Try to earn more next time!");
        isRunning=false;
    }

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
            if(input==1){
                clearconsole();
                continueJourney();}
            else if(input==2)
                characterInfo();
            else
                isRunning=false;
        }
    }


    }




