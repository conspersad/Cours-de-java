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
        int size = 0;
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
            Execution.anythingtocontinue();
        wizard = new Wizard(name, Pet.choosePet(),Wand.choose_wand()  ,House.your_house()); //appel de joueuer
        System.out.println();

        //setting isRunning to true so the game loop can continue
        isRunning =true;

        }
        //method to continue the journey
    public static void continueJourney(){

    }
    //printing out the most important information about the payer charcter
    public static void printMenu(){
        clearconsole();
        printHeading(places[place]);
        System.out.println("choose an action:");
        printseperator(20);
        System.out.println("(1) Continue your journey");
        System.out.println("(2) Character info");
        System.out.println("(3) Exit game");

    }


    }





