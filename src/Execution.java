import java.util.Scanner;
import java.lang.System;
import java.lang.String;
import java.util.Timer;
import java.util.TimerTask;


public class Execution {
    Game game= new Game();
    House Hue= new House();
    Wand wnd = new Wand();
    static Scanner scanner = new Scanner(System.in);
    public static Wizard wizard;
    public static Enemy enemy,enemy1;
    public static int nbr_accio=0;
    public static int firework=0;
    public static String patronus;
    boolean go_with_voldemort=false;
    public static int place =0,level=1;
    public static String[] places ={"The philosopher's stone","The chamber of secret","The prisoner of azkaban", "The goblet of fire","The order of the phoenix","The half-blood prince","The deathly Hallows"};



    //methode pour commencer le jeu
    public void  startGame(){
        boolean nameSet = false;
        String name;
        // print title screen
        game.clearconsole();
        game.printseperator(20);
        System.out.println("Harry Potter");
        System.out.println("BY CONSTANCE PERSAD");
        game.printseperator(20);
        game.anythingtocontinue();

        do {
            game.clearconsole();
            game.printHeading("What's your name ?");
            name = scanner.next();
            //asking the player if he wants to correct his choice
            game.clearconsole();
            game. printHeading("Your name is " + name + ".\nIs that correct ?");
            System.out.println("(1) Yes !");
            System.out.println("(2) No i want to change my name !");
            int input = Game.readInt("->", 2);
            if (input == 1)
                nameSet = true;
        }while(!nameSet);

        Story.printIntro();

        game.anythingtocontinue();

        wizard=new Wizard(name,100,0,Hue.your_house(),Pet.choosePet(), Wand.choose_wand());

        //wizard = new Wizard(name,House.your_house() ,pet.choosePet(),Wand.choose_wand() , 100); //appel de joueuer

        //setting isRunning to true so the game loop can continue
        game.isRunning =true;

        //start main game loop
        game.gameLoop();

        }
        //method to continue the journey


   public  void checkAct(){
        if( level==1){
            //Story.Thephilosopherstone_Intro();
            //enemy = new Enemy("Troll", 30, 10);
            //battle();
            //Story.Thephilosopherstone_Outro();
            game.clearconsole();
            game.anythingtocontinue();
            level=2;
            place=1;
            game.gameLoop();

        }else if(level==2){
            //Story.TheChamberOfSecret_Intro();
           // enemy = new Enemy("Basilic", 30, 60);
           // battle();
            //Story.TheChamberOfSecret_Outro();
            game.clearconsole();
            game. anythingtocontinue();
            level=3;
            place=2;
            game.gameLoop();

        }else if(level==3){
         //  Story.The_prisoner_of_azkaban_Intro();
         //  this.enemy = new Enemy("Dementor", 50,70 );
           // patronus =Patronus.your_patronus();
           // battle();
//             Story.The_prisoner_of_azkaban_Outro();
            game.clearconsole();
            game.anythingtocontinue();
            level=4;
            place=3;
            game.gameLoop();

        }else if( level==4){
            //Story.The_goblet_of_fire_Intro();
            enemy = new Enemy("Voldemort", 45,20);
           enemy1 = new Enemy("Peter Pettigrow", 30,70 );
          // battle_level4();
           // Story.The_goblet_of_fire_Outro();
            game.clearconsole();
            game.anythingtocontinue();
            level=5;
            place=4;
            game.gameLoop();

        }else if(level==5){
            //Story.The_order_of_the_phoenix_Intro();
           // enemy = new Enemy("Dolores Ombrage", 45,70 );
            //battle_level5();
            //Story.The_order_of_the_phoenix_Outro();
            game.clearconsole();
            game.anythingtocontinue();
            level=6;
            place=5;
            game.gameLoop();

        }else if(level==6){
           // Story.The_half_blood_prince_Outro();
            enemy = new Enemy("Death Eater", 55,170);
            battle_6();
            level=7;
            place=6;
        }

   }
   public  void battle(){

       // Boucle principale du jeu
       while (wizard.isAlive() && enemy.isAlive()) {
           wizard.xp=Spell.damage;
           // Tour du sorcier
           System.out.println( wizard.getName() + " (" + wizard.hp
                   + " hp, " + wizard.getXp() + " Xp) vs " + enemy.getName() + " (" + enemy.getHp() + " hp, " +  enemy.getXp() + " xp)");
           String message ="What do you want to do ?\n"+
                   "1 - Fight "+ enemy.getName()+" !\n" +
                   "2 - Use a sort to have more Hp (only if your life is < 100)\n"
                   +"3 - Leave";
           game.slowPrint(message,1);
           int choice = game.readInt("->",3);
           switch (choice) {
               case 1 -> {
                   int damage =  wizard.attack();
                   int reducedDamage = enemy.defend();
                   int totalDamage = reducedDamage * damage;
                   int enemy_hp = enemy.getHp()- totalDamage;
                   enemy.setHp(enemy_hp);

                   String message1 = wizard.getName()+ " attack inflict " + damage + " damage points\n";
                   game.slowPrint(message1,1);

                   if(totalDamage==0){
                       String message2= enemy.getName() + " dodge your attack\n";
                       game.slowPrint(message2,1);
                   }else {

                       String message3= enemy.getName() + " was hit!\n";
                       game.slowPrint(message3,1);
                   }
               }
               case 2 -> {
                   if((Execution.wizard.house.equals("Hufflepuff"))&&(wizard.getHp() <100))
                   {
                       int healed = 20;
                       wizard.setHp(wizard.getHp() +healed);
                       System.out.println("You healed "+ healed+" Hp !\n");
                       Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                   }else if((!Execution.wizard.house.equals("Hufflepuff"))&&(wizard.getHp()<100)){
                       int healed = 25;
                       System.out.println("You healed "+ healed+" Hp !\n");
                       wizard.setHp(wizard.getHp() +healed);
                       Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                   }  else if (wizard.getHp() >=100) {
                       System.out.println("You have enough hp\n");
                   }
               }

               case 3 -> {
                   System.out.println(wizard.getName() + " leave");
                   System.out.println("You are either very smart or either a little bit coward");
                   game.gameLoop();
               }
               default -> System.out.println("Choice not valid");
           }

           if (enemy.isAlive()) {
               int damage = enemy.attack();
               int reducedDamage = wizard.defend();
               int totalDamage = reducedDamage * damage;
               int wizard_hp = wizard.getHp()- totalDamage;
               wizard.setHp(wizard_hp);
               String message4 = enemy.getName() + " attack causing " + damage + " damage points. \n\n"
                       + wizard.getName() + " take " + totalDamage + " damage points.\n";
               game.slowPrint(message4,75);
           }
       }
       // Fin du jeu
       if (wizard.isAlive()) {
           String message5 = wizard.getName()+ " defeat " + enemy.getName() + " !\n";
           game.slowPrint(message5,25);
       } else {
           String message6= enemy.getName()+ " defeat " + wizard.getName()+ " !\n";
           game.slowPrint(message6,25);
           game.wizardDied();
       }
   }

    public  void battle_level4() {
        // Boucle principale du jeu
        while (wizard.isAlive() && enemy.isAlive() && enemy1.isAlive() && (nbr_accio !=3)){
            // Tour du sorcier
            System.out.println( wizard.getName() + " (" + wizard.hp + " hp, " + wizard.getXp() + " Xp) vs " + enemy.getName() + " (" + enemy.getHp() + " hp, " +  enemy.getXp() + " xp)");
            String message = "What do you want to do ?\n" +
                    "1 - Attack " + enemy.getName() + " !\n" +
                    "2 - Attack " + enemy1.getName() + " !\n" +
                    "3 - Use a sort to have more Hp (only if your life is < 100)\n"+
                    "4 - Leave";
            game.slowPrint(message, 1);
            int choice = game.readInt("->",4);
            switch (choice) {
                case 1 -> {
                    int damage = wizard.attack();
                    int reducedDamage = enemy.defend();
                    int totalDamage = reducedDamage * damage;
                    enemy.setHp( enemy.getHp() - totalDamage);
                    String message1 = wizard.getName() + " inflict " + damage + " damage points\n";
                    game.slowPrint(message1, 1);
                    if (totalDamage == 0) {
                        String message2 = enemy.getName() + " dodge your attack\n";
                        game.slowPrint(message2, 1);
                    } else {
                        String message3 = enemy.getName() + " was hit!\n";
                        game.slowPrint(message3, 1);
                    }

                }
                case 2 -> {
                    int damage = wizard.attack();
                    int reducedDamage = enemy1.defend();
                    int totalDamage = reducedDamage * damage;
                    enemy1.setHp(enemy1.hp - totalDamage);
                    String message1 = wizard.getName() + " inflict " + damage + " damage points\n";
                    game.slowPrint(message1, 1);
                    if (totalDamage == 0) {
                        String message2 = enemy1.getName() + " dodge your attack\n";
                        game.slowPrint(message2, 1);
                    } else {
                        String message3 = enemy1.getName() + " was hit!\n";
                        game.slowPrint(message3, 1);
                    }

                }
                case 3 -> {
                    if ((Execution.wizard.house.equals("Hufflepuff")) && (enemy.getHp() < 100)) {
                        int healed = 20;
                        wizard.setHp(wizard.getHp() + healed);
                        System.out.println("You healed " + healed + " Hp !\n");
                        Wizard.nbr_de_potion = wizard.nbr_de_potion - 1;

                    } else if ((!Execution.wizard.house.equals("Hufflepuff")) && (enemy.getHp() < 100)) {
                        int healed = 25;
                        System.out.println("You healed " + healed + " Hp !\n");
                        wizard.setHp(wizard.getHp() + healed);
                        Wizard.nbr_de_potion = Wizard.nbr_de_potion - 1;

                    } else if (wizard.getHp() >= 100) {
                        System.out.println("You have enough hp\n");
                    }
                }

                case 4 -> {
                    System.out.println(wizard.getName() + " leave");
                    System.out.println("You are either very smart or either a little bit coward");
                    game.gameLoop();
                }
                default -> System.out.println("Choice not valid");
            }
            if (Math.random() > 0.5) {
                if (enemy.isAlive()) {
                    int damage = enemy.attack();
                    int reducedDamage = wizard.defend();
                    int totalDamage = reducedDamage * damage;
                    wizard.setHp(wizard.getHp() - totalDamage);
                    String message4 = enemy.getName() + " attack causing " + damage + " damage points. \n";
                    game.slowPrint(message4, 75);
                }
            } else {
                if (enemy1.isAlive()) {
                    int damage = enemy1.attack();
                    int reducedDamage = wizard.defend();
                    int totalDamage = reducedDamage * damage;
                    wizard.setHp(wizard.getHp() - totalDamage);
                    String message4 = enemy1.getName() + " attack causing " + damage + " damage points. \n";


                    game.slowPrint(message4, 75);
                }
            }}
        // Fin du jeu
        if(nbr_accio==3) {
            String message6 = "You managed to attract the Portolion, and thus to escape!\n" +
                    "It was a close one, you are very lucky ! \n";
            game.slowPrint(message6, 25);
        } else {
            if (wizard.isAlive()) {
                String message5 = wizard.name + " defeat " + enemy.name + " !\n";
                game.slowPrint(message5, 25);
            } else if (enemy.isAlive()) {
                String message6 = enemy.name + " defeat " + wizard.name + " !\n";
                game.slowPrint(message6, 25);
                game.wizardDied();
            } else if (enemy1.isAlive()) {
                String message6 = enemy.name + " defeat " + wizard.name + " !\n";
                game.slowPrint(message6, 25);
                game.wizardDied();
            }
        }}
      public void battle_level5(){
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
           System.out.println( wizard.getName() + " (" + wizard.hp + " hp, " + wizard.getXp() + " Xp) vs " + enemy.getName() + " (" + enemy.getHp() + " hp, " +  enemy.getXp() + " xp)");
           String message ="What do you want to do ?\n"+
           "1 - Distract "+ enemy.getName() +" during 15 secondes while your friend prepare a firework!\n" +
           "2 - Prepare a 2 firework (it take 5 secondes)\n"+
            "3 - Use a sort to have more Hp (only if your life is < 100)\n"+
            "4 - Leave";
           game.slowPrint(message,1);
           int choice = game.readInt("->",4);
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
                       wizard.setHp(wizard.getHp() - damage);
                       firework=firework-1;
                   }

               }
                   case 3 -> {
                       if((Execution.wizard.house.equals("Hufflepuff"))&&(wizard.getHp() <100))
                       {
                           int healed = 20;
                           wizard.setHp(wizard.getHp()+healed);
                           System.out.println("You healed "+ healed+" Hp !\n");
                           Wizard.nbr_de_potion =wizard.nbr_de_potion-1;

                       }else if((!Execution.wizard.house.equals("Hufflepuff"))&&(wizard.getHp() <100)){
                           int healed = 25;
                           System.out.println("You healed "+ healed+" Hp !\n");
                           wizard.setHp(wizard.getHp() +healed);
                           Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                       }  else if (wizard.getHp() >=100) {
                           System.out.println("You have enough hp\n");
                       }
                   }
                   default -> System.out.println("Choice not valid");
               case 4 -> {
                   System.out.println(wizard.name + " leave");
                   System.out.println("You are either very smart or either a little bit coward");
                   game.gameLoop();
               }
           }}

       // Fin du jeu
       if (firework == 6 ) {
           String message5 = wizard.getName()+ " prepared enough firework during the allotted time and so defeat " + enemy.getName() + " !\n";
           game.slowPrint(message5,75);
       } else if(finDuTimer[0]) {
           String message6= "You didn't prepare enough firework during the alloted time";
           game.slowPrint(message6,75);
           game.wizardDied();
       }
   }
    public  void battle_6(){
        if (wizard.house=="Slytherin"){
        // Boucle principale du jeu
        while (wizard.isAlive() && enemy.isAlive()) {
            wizard.xp=Spell.damage;
            // Tour du sorcier
            System.out.println( wizard.getName() + " (" + wizard.hp + " hp, " + wizard.getXp() + " Xp) vs " + enemy.getName() + " (" + enemy.getHp() + " hp, " +  enemy.getXp() + " xp)");
            String message ="What do you want to do ?\n"+
                    "1 - Fight "+ enemy.getName() +" !\n" +
                    "2 - Use a sort to have more Hp (only if your life is < 100)\n"+
                    "3 - You are Slytherin you can join Death Eaters\n"
                    +"4 - Leave";
            game.slowPrint(message,1);
            int choice = game.readInt("->",4);
            switch (choice) {
                case 1 -> {
                    int damage = wizard.attack();
                    int reducedDamage = enemy.defend();
                    int totalDamage = reducedDamage * damage;
                    enemy.setHp(enemy.getHp() - totalDamage);
                    String message1 = wizard.getName() + " inflict " + damage + " damage points\n";
                    game.slowPrint(message1,1);
                    if(totalDamage==0){
                        String message2= enemy.getName() + " dodge your attack\n";
                        game.slowPrint(message2,1);
                    }else {
                        String message3= enemy.getName() + " was hit!\n";
                        game.slowPrint(message3,1);
                    }

                }
                case 2 -> {
                    if((Execution.wizard.house.equals("Hufflepuff"))&&(wizard.getHp() <100))
                    {
                        int healed = 20;
                        wizard.setHp(wizard.getHp()+healed);
                        System.out.println("You healed "+ healed+" Hp !\n");
                        Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                    }else if((!Execution.wizard.house.equals("Hufflepuff"))&&(wizard.getHp() <100)){
                        int healed = 25;
                        System.out.println("You healed "+ healed+" Hp !\n");
                        wizard.setHp(wizard.getHp() +healed);
                        Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                    }  else if (wizard.getHp()>=100) {
                        System.out.println("You have enough hp\n");
                    }
                }

                case 3 -> {
                    System.out.println("You decided to join Voldemort army, you will have to figth against your friend");
                    go_with_voldemort=true;
                    game.gameLoop();
                }
                case 4 -> {
                    System.out.println(wizard.getName()+ " leave");
                    System.out.println("You are either very smart or either a little bit coward");
                    game.gameLoop();
                }
                default -> System.out.println("Choice not valid");
            }

            if (enemy.isAlive()) {
                int damage = enemy.attack();
                int reducedDamage = wizard.defend();
                int totalDamage = reducedDamage * damage;
                wizard.setHp(wizard.getHp() - totalDamage);
                String message4 = enemy.getName() + " attack causing " + damage + " damage points. \n\n"
                        +wizard.getName() + " take " + totalDamage + " damage points.\n";
                game.slowPrint(message4,75);
            }
        }
        // Fin du jeu
        if (wizard.isAlive()) {
            String message5 = wizard.getName()+ " defeat " + enemy.getName()+ " !\n";
            game.slowPrint(message5,25);
        } else {
            String message6= enemy.getName() + " defeat " + wizard.getName() + " !\n";
            game.slowPrint(message6,25);
            game.wizardDied();
        }
    }else {
                // Boucle principale du jeu
                while (wizard.isAlive() && enemy.isAlive()) {
                    wizard.xp = Spell.damage;
                    // Tour du sorcier
                    System.out.println(wizard.getName() + " (" + wizard.hp + " hp, " + wizard.getXp() + " Xp) vs " + enemy.getName() + " (" + enemy.getHp() + " hp, " + enemy.getXp() + " xp)");
                    String message = "What do you want to do ?\n" +
                            "1 - Fight " + enemy.getName() + " !\n" +
                            "2 - Use a sort to have more Hp (only if your life is < 100)\n" +
                            "3 - Leave";
                    game.slowPrint(message, 1);
                    int choice = game.readInt("->", 4);
                    switch (choice) {
                        case 1 -> {
                            int damage = wizard.attack();
                            int reducedDamage = enemy.defend();
                            int totalDamage = reducedDamage * damage;
                            enemy.setHp(enemy.getHp() - totalDamage);
                            String message1 = wizard.getName() + " inflict " + damage + " damage points\n";
                            game.slowPrint(message1, 1);
                            if (totalDamage == 0) {
                                String message2 = enemy.getName() + " dodge your attack\n";
                                game.slowPrint(message2, 1);
                            } else {
                                String message3 = enemy.getName() + " was hit!\n";
                                game.slowPrint(message3, 1);
                            }

                        }
                        case 2 -> {
                            if ((Execution.wizard.house.equals("Hufflepuff")) && (wizard.getHp() < 100)) {
                                int healed = 20;
                                wizard.setHp(wizard.getHp() + healed);
                                System.out.println("You healed " + healed + " Hp !\n");
                                Wizard.nbr_de_potion = Wizard.nbr_de_potion - 1;

                            } else if ((!Execution.wizard.house.equals("Hufflepuff")) && (wizard.getHp() < 100)) {
                                int healed = 25;
                                System.out.println("You healed " + healed + " Hp !\n");
                                wizard.setHp(wizard.getHp() + healed);
                                Wizard.nbr_de_potion = Wizard.nbr_de_potion - 1;

                            } else if (wizard.getHp() >= 100) {
                                System.out.println("You have enough hp\n");
                            }
                        }

                        case 3 -> {
                            System.out.println(wizard.getName() + " leave");
                            System.out.println("You are either very smart or either a little bit coward");
                            game.gameLoop();
                        }
                        default -> System.out.println("Choice not valid");
                    }

                    if (enemy.isAlive()) {
                        int damage = enemy.attack();
                        int reducedDamage = wizard.defend();
                        int totalDamage = reducedDamage * damage;
                        wizard.setHp(wizard.getHp() - totalDamage);
                        String message4 = enemy.getName() + " attack causing " + damage + " damage points. \n\n"
                                + wizard.getName() + " take " + totalDamage + " damage points.\n";
                        game.slowPrint(message4, 75);
                    }
                }
                // Fin du jeu
                if (wizard.isAlive()) {
                    String message5 = wizard.getName() + " defeat " + enemy.getName() + " !\n";
                    game.slowPrint(message5, 25);
                } else {
                    String message6 = enemy.getName() + " defeat " + wizard.getName() + " !\n";
                    game.slowPrint(message6, 25);
                    game.wizardDied();
                }
            }
        }
    public static int Getnbr_accio(){return nbr_accio;}
    public static int Getlevel(){return level;}
    public void continueJourney(){
        //check if game isn't in last act
        if(level != 7) checkAct();

    }
}




