import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.System;
import java.lang.String;
public class Execution {
    static Scanner scanner = new Scanner(System.in);

    static Joueur joueur;
    public static int place =0,level;
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
        scanner.next();

    }
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
        printseperator(30);
        System.out.println("Harry Potter");
        System.out.println("BY CONSTANCE PERSAD");
        printseperator(30);
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
             System.out.println("Welcome to Poudlard "+name+" I don't doubt that this would be the best years of your life ! " +
                     " But before your adventure starts, you have to buy your fournitures !!");
        //create new player object with the name
        joueur = new Joueur(name); //appel de joueuer

        //setting isRunning to true so the game loop can continue
        isRunning =true;
        //start main game loop
        gameLoop();
        }
        //method to continue the journey
    public static void continueJourney(){

    }
    //printing out the most important information about the payer charcter
    public static void characterInfo(){
        clearconsole();
        printHeading("Character info");
        System.out.println(joueur.name + "\tHP:" + joueur.hp+"/"+joueur.maxHp);
        printseperator(20);
        System.out.println("XP/"+joueur.xp);

        //printing the chosen trait
        if(joueur.numAtaUpgrades>0){
            System.out.println("Offensive trait :"+joueur.attUpgrades[joueur.numAtaUpgrades-1]);
            printseperator(20);
        }
        if(joueur.numDefUpgrades>0){
            System.out.println("Defensive trait :"+joueur.defUpgrades[joueur.numDefUpgrades-1]);
            printseperator(20);
        }
        anythingtocontinue();
    }
    //printing the main menu
    public static void printMenu(){
        clearconsole();
        printHeading(places[place]);
        System.out.println("choose an action:");
        printseperator(20);
        System.out.println("(1) Continue your journey");
        System.out.println("(2) Character info");
        System.out.println("(3) Exit game");



    }

        //main game loop
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




