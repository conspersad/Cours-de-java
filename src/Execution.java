import java.util.Scanner;
import java.lang.System;
import java.lang.String;
import java.util.Timer;
import java.util.TimerTask;


public class Execution {
    static Scanner scanner = new Scanner(System.in);
    static Wizard wizard;
    static Enemy enemy,enemy1;
    public static int nbr_accio=0;
    public static int firework=0;
    public static String patronus;
    public static int place =0,level=1;
    public static String[] places ={"The philosopher's stone","The chamber of secret","The prisoner of azkaban", "The goblet of fire","The order of the phoenix","The half-blood prince","The deathly Hallows"};

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
            //Story.Thephilosopherstone_Intro();
            //enemy = new Enemy("Troll", 10, 30);
            //battle();
            //Story.Thephilosopherstone_Outro();
            clearconsole();
            anythingtocontinue();
            level=2;
            place=1;
            gameLoop();

        }else if(  level==2){
            //Story.TheChamberOfSecret_Intro();
            //enemy = new Enemy("Basilic", 30, 60);
            //battle();
            //Story.TheChamberOfSecret_Outro();
            clearconsole();
            anythingtocontinue();
            level=3;
            place=2;
            gameLoop();

        }else if(level==3){
            Story.The_prisoner_of_azkaban_Intro();
            enemy = new Enemy("Dementor", 45,70 );
            patronus =Patronus.your_patronus();
             battle();
             Story.The_prisoner_of_azkaban_Outro();
            clearconsole();
            anythingtocontinue();
            level=4;
            place=3;
            gameLoop();

        }else if( level==4){
            Story.The_goblet_of_fire_Intro();
            enemy = new Enemy("Voldemort", 45,20);
            enemy1 = new Enemy("Peter Pettigrow", 30,70 );
            battle_level4();
            Story.The_goblet_of_fire_Outro();
            clearconsole();
            anythingtocontinue();
            level=5;
            place=4;
            gameLoop();

        }else if(level==5){
            enemy = new Enemy("Dolores Ombrage", 45,70 );
            battle_level5();
            level=6;
            place=5;

        }else if((Character.xp >= 70 && Character.xp <=90) &&level==6){
            level=7;
            place=6;
        }

   }
    public static void battle_level5(){
        int dureeMillis = 100000;
        final Timer timer = new Timer();
        final boolean[] finDuTimer = {false};
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                finDuTimer[0] = true;
                timer.cancel();
            }
        }, dureeMillis);

        boolean preparationEnCours;
       while ((firework != 6) && (!finDuTimer[0])){
           // Tour du sorcier
           System.out.println(wizard.name + " (" + Wizard.hp + " hp, " + wizard.xp + " Xp) vs " + enemy.name + " (" + Enemy.hp + " hp, " + Enemy.xp + " xp)");
           String message ="What do you want to do ?\n"+
           "1 - Distract "+enemy.name+" during 15 secondes while your friend prepare a firework!\n" +
           "2 - Prepare a 2 firework (it take 5 secondes)\n"
           +"3 - Use a sort to have more Hp (only if your life is < 100)\n"+
                   "4 - Leave";
           slowPrint(message,1);
           int choice = scanner.nextInt();
           switch (choice) {
               case 1 -> {
                   preparationEnCours=false;
                   firework=Wizard.distraireEnnemi();
                   int damage = Enemy.verifierPreparationFeuArtifice(preparationEnCours);
               }
               case 2 -> {
                   preparationEnCours=true;
                   firework = Wizard.prepare_firework();
                   int damage = Enemy.verifierPreparationFeuArtifice(preparationEnCours);
                   if(damage==0){
                       System.out.println("Dolores didn't see you preparing the firework ! Continue");
                   }else{
                       System.out.println("Dolores caught you preparing  firework, you lose "+damage +" hp and lost 1 firework");
                       wizard.setHp(Wizard.hp - damage);
                       firework=firework-1;
                   }

               }
                   case 3 -> {
                       if((Execution.wizard.house.equals("Hufflepuff"))&&(Wizard.hp <100))
                       {
                           int healed = 20;
                           wizard.setHp(Wizard.hp +healed);
                           System.out.println("You healed "+ healed+" Hp !\n");
                           Wizard.nbr_de_potion =wizard.nbr_de_potion-1;

                       }else if((!Execution.wizard.house.equals("Hufflepuff"))&&(Wizard.hp <100)){
                           int healed = 25;
                           System.out.println("You healed "+ healed+" Hp !\n");
                           wizard.setHp(Wizard.hp +healed);
                           Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                       }  else if (Wizard.hp >=100) {
                           System.out.println("You have enough hp\n");
                       }
                   }
                   default -> System.out.println("Choice not valid");
               case 4 -> {
                   System.out.println(wizard.name + " leave");
                   System.out.println("You are either very smart or either a little bit coward");
                   gameLoop();
               }
           }}

       // Fin du jeu
       if (firework == 6 ) {
           String message5 = wizard.name+ " prepared enough firework during the allotted time and so defeat " + enemy.name + " !\n";
           slowPrint(message5,75);
       } else if(finDuTimer[0]) {
           String message6= "You didn't prepare enough firework during the alloted time";
           slowPrint(message6,75);
           wizardDied();
       }
   }
    public static void battle(){
        // Boucle principale du jeu
        while (wizard.isAlive() && enemy.isAlive()) {
            wizard.xp=Spell.damage;
            // Tour du sorcier
            System.out.println(wizard.name + " (" + Wizard.hp + " hp, " + wizard.xp + " Xp) vs " + enemy.name + " (" + Enemy.hp + " hp, " + Enemy.xp + " xp)");
            String message ="What do you want to do ?\n"+
                    "1 - Fight "+enemy.name+" !\n" +
                    "2 - Use a sort to have more Hp (only if your life is < 100)\n"
                    +"3 - Leave";
            slowPrint(message,1);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    int damage = wizard.attack();
                    int reducedDamage = enemy.defend();
                    int totalDamage = reducedDamage * damage;
                    enemy.setHp(Enemy.hp - totalDamage);
                    String message1 = wizard.name + " inflict " + damage + " damage points\n";
                    slowPrint(message1,1);
                    if(totalDamage==0){
                        String message2= enemy.name + " dodge your attack\n";
                        slowPrint(message2,1);
                    }else {
                        String message3= Execution.enemy.name + " was hit!\n";
                        slowPrint(message3,1);
                    }

                }
                case 2 -> {
                    if((Execution.wizard.house.equals("Hufflepuff"))&&(Wizard.hp <100))
                    {
                        int healed = 20;
                        wizard.setHp(Wizard.hp +healed);
                        System.out.println("You healed "+ healed+" Hp !\n");
                        Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                    }else if((!Execution.wizard.house.equals("Hufflepuff"))&&(Wizard.hp <100)){
                        int healed = 25;
                        System.out.println("You healed "+ healed+" Hp !\n");
                        wizard.setHp(Wizard.hp +healed);
                        Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                    }  else if (Wizard.hp >=100) {
                        System.out.println("You have enough hp\n");
                    }
                }

                case 3 -> {
                    System.out.println(wizard.name + " leave");
                    System.out.println("You are either very smart or either a little bit coward");
                    gameLoop();
                }
                default -> System.out.println("Choice not valid");
            }

            if (enemy.isAlive()) {
                int damage = enemy.attack();
                int reducedDamage = wizard.defend();
                int totalDamage = reducedDamage * damage;
                wizard.setHp(Wizard.hp - totalDamage);
                String message4 = enemy.name + " attack causing " + damage + " damage points. \n\n"
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

    public static void battle_level4() {
        // Boucle principale du jeu
        while (wizard.isAlive() && enemy.isAlive() && enemy1.isAlive() && (nbr_accio !=3)){
            // Tour du sorcier
            System.out.println(wizard.name + " (" + Wizard.hp + " hp, " + wizard.xp + " Xp) vs " + enemy.name + " (" + Enemy.hp + " hp, " + Enemy.xp + " xp) and vs "
                    + enemy1.name + " (" + Enemy.hp + " hp, " + Enemy.xp + " xp)");
            String message = "What do you want to do ?\n" +
                    "1 - Attack " + enemy.name + " !\n" +
                    "2 - Attack " + enemy1.name + " !\n" +
                    "3 - Use a sort to have more Hp (only if your life is < 100)\n"
                    + "4 - Leave";
            slowPrint(message, 1);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    int damage = wizard.attack();
                    int reducedDamage = enemy.defend();
                    int totalDamage = reducedDamage * damage;
                    enemy.setHp(Enemy.hp - totalDamage);
                    String message1 = wizard.name + " inflict " + damage + " damage points\n";
                    slowPrint(message1, 1);
                    if (totalDamage == 0) {
                        String message2 = enemy.name + " dodge your attack\n";
                        slowPrint(message2, 1);
                    } else {
                        String message3 = Execution.enemy.name + " was hit!\n";
                        slowPrint(message3, 1);
                    }

                }
                case 2 -> {
                    int damage = wizard.attack();
                    int reducedDamage = enemy1.defend();
                    int totalDamage = reducedDamage * damage;
                    enemy1.setHp(enemy1.hp - totalDamage);
                    String message1 = wizard.name + " inflict " + damage + " damage points\n";
                    slowPrint(message1, 1);
                    if (totalDamage == 0) {
                        String message2 = enemy1.name + " dodge your attack\n";
                        slowPrint(message2, 1);
                    } else {
                        String message3 = Execution.enemy1.name + " was hit!\n";
                        slowPrint(message3, 1);
                    }

                }
                case 3 -> {
                    if ((Execution.wizard.house.equals("Hufflepuff")) && (Wizard.hp < 100)) {
                        int healed = 20;
                        wizard.setHp(Wizard.hp + healed);
                        System.out.println("You healed " + healed + " Hp !\n");
                        Wizard.nbr_de_potion = wizard.nbr_de_potion - 1;

                    } else if ((!Execution.wizard.house.equals("Hufflepuff")) && (Wizard.hp < 100)) {
                        int healed = 25;
                        System.out.println("You healed " + healed + " Hp !\n");
                        wizard.setHp(Wizard.hp + healed);
                        Wizard.nbr_de_potion = Wizard.nbr_de_potion - 1;

                    } else if (Wizard.hp >= 100) {
                        System.out.println("You have enough hp\n");
                    }
                }

                case 4 -> {
                    System.out.println(wizard.name + " leave");
                    System.out.println("You are either very smart or either a little bit coward");
                    gameLoop();
                }
                default -> System.out.println("Choice not valid");
            }
            if (Math.random() > 0.5) {
                if (enemy.isAlive()) {
                    int damage = enemy.attack();
                    int reducedDamage = wizard.defend();
                    int totalDamage = reducedDamage * damage;
                    wizard.setHp(Wizard.hp - totalDamage);
                    String message4 = enemy.name + " attack causing " + damage + " damage points. \n";
                    slowPrint(message4, 75);
                }
            } else {
                if (enemy1.isAlive()) {
                    int damage = enemy1.attack();
                    int reducedDamage = wizard.defend();
                    int totalDamage = reducedDamage * damage;
                    wizard.setHp(Wizard.hp - totalDamage);
                    String message4 = enemy1.name + " attack causing " + damage + " damage points. \n";


                    slowPrint(message4, 75);
                }
            }}
            // Fin du jeu
            if(nbr_accio==3) {
                String message6 = "You managed to attract the Portolion, and thus to escape!\n" +
                        "It was a close one, your very lucky ! \n";
                slowPrint(message6, 25);
            } else {
                if (wizard.isAlive()) {
                    String message5 = wizard.name + " defeat " + enemy.name + " !\n";
                    slowPrint(message5, 25);
                } else if (enemy.isAlive()) {
                    String message6 = enemy.name + " defeat " + wizard.name + " !\n";
                    slowPrint(message6, 25);
                    wizardDied();
                } else if (enemy1.isAlive()) {
                    String message6 = enemy.name + " defeat " + wizard.name + " !\n";
                    slowPrint(message6, 25);
                    wizardDied();
                }
            }}


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
    public static int Choose_spell(){
        int damage = 0;
        System.out.println("Choose a spell");

        int spellCount = Execution.level;  // number of available spells
        if((Execution.level==1)){
            for (int i = 0; i < spellCount; i++) {

                System.out.println((i + 1) + " : " + Spell.spells[i]);
            }
            int input = Execution.readInt("->", spellCount);
            if (input == 1) {
                damage = 10;
            } else{ System.out.println("Please enter a valide value");
              Choose_spell();}
        }
        else if((Execution.level==2)&& (Execution.wizard.house.equals("Gryffindor")))
        {
            for (int i = 0; i < spellCount; i++) {
                System.out.println((i + 1) + " : " + Spell.spells[i]);}
            spellCount=spellCount+1;
            System.out.println("3 : Use the legend sword of Godric Gryffindor  ");
            int input = Execution.readInt("->", spellCount);
            if (input == 1) {
                damage = 10;
            } else if (input == 2) {
                damage = 20;
            }else if (input == 3) {
                damage = 45;
            }
        }
        else if((Execution.level==2)&& (!Execution.wizard.house.equals("Gryffindor"))) {
            for (int i = 0; i < spellCount; i++) {
                System.out.println((i + 1) + " : " + Spell.spells[i]);}
            int input = Execution.readInt("->", spellCount);
            if (input == 1) {
                damage = 10;
            } else if (input == 2) {
                damage = 20;
            }
        }
        else if((Execution.level==3)){
            System.out.println(" Use Expecto Patronum a "+patronus);
            switch (patronus) {
                case "Deer" -> damage = 28;
                case "Eagle" -> damage = 30;
                case "Horse" -> damage = 32;
                default -> {
                    System.out.println("Please enter a valide value");
                    Choose_spell();
                }
            }}
        else if(Execution.level==4){
            spellCount=2;
            for (int i = 0; i < spellCount; i++) {
                System.out.println((i + 1) + " : " + Spell.spells[i]);}
            int input = Execution.readInt("->", spellCount);
            if (input == 1) {
                damage = 10;
            } else if (input == 2) {
                nbr_accio=nbr_accio+1;
                damage = 20;
            }
        }
        return damage;      }




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




