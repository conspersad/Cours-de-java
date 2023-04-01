import java.util.Scanner;
import java.lang.System;
import java.lang.String;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    public boolean isRunning;
    public void printseperator(int n){
        for(int i=0;i<n;i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public void printHeading(String title){
        printseperator(30);
        System.out.println(title);
        printseperator(30);}
    public void anythingtocontinue(){
        System.out.println("\nEnter something to continue...");
        scanner.next();}
    public void clearconsole(){
        for(int i=0; i<5;i++)
            System.out.println();
    }
    public  int readInt(String prompt, int Userchoice) {
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

    public void slowPrint(String message, int delay) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }


    public void wizardDied(){
        clearconsole();
        printHeading("You died...");
        printHeading("You earned " + Execution.wizard.xp + " XP on your journey.Try to earn more next time!");
        isRunning=false;
    }

    public void characterInfo(){
        clearconsole();
        printHeading("Character info");
        System.out.println(Execution.wizard.getName() + "Your Pet : " + Execution.wizard.pet + "\nThe size of your wand : " +Execution.wizard.wand + "\nYour house is :" + Execution.wizard.house);
        printseperator(5);
    }
    public void printMenu(){
        clearconsole();
        printHeading(Execution.places[Execution.place]);
        System.out.println("choose an action:");
        printseperator(20);
        System.out.println("(1) Continue your journey");
        System.out.println("(2) Character info");
        System.out.println("(3) Exit game");

    }
    public  void gameLoop(){
        Execution exc =new Execution();
        while(isRunning){
            printMenu();
            int input = readInt("->",3);
            if(input==1){
                clearconsole();
                exc.continueJourney();}
            else if(input==2)
                characterInfo();
            else
                isRunning=false;
        }
    }
    public  int Choose_spell(){
        int damage = 0;
        System.out.println("Choose a spell");

        int spellCount = Execution.Getlevel();  // number of available spells
        if((Execution.level==1)){
            for (int i = 0; i < spellCount; i++) {

                System.out.println((i + 1) + " : " + Spell.spells[i]);
            }
            int input = readInt("->", spellCount);
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
            int input = readInt("->", spellCount);
            if (input == 1) {
                damage = 10;
            } else if (input == 2) {
                damage = 20;
            }else if (input == 3) {
                damage = 45;
            }
        }
        else if(Execution.level == 2) {
            for (int i = 0; i < spellCount; i++) {
                System.out.println((i + 1) + " : " + Spell.spells[i]);}
            int input = readInt("->", spellCount);
            if (input == 1) {
                damage = 10;
            } else if (input == 2) {
                damage = 20;
            }
        }
       else if((Execution.level==3)){
            System.out.println(" Use Expecto Patronum a "+ Execution.patronus);
            switch (Execution.patronus) {
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
            int input = readInt("->", spellCount);
            if (input == 1) {
                damage = 10;
            } else if (input == 2) {
                Execution.nbr_accio= 1 +Execution.Getnbr_accio();
                damage = 20;
            }
        }
        else if(Execution.level==6){
            spellCount=4;
            for (int i = 0; i < spellCount; i++) {
                System.out.println((i + 1) + " : " + Spell.spells[i]);}
            int input = readInt("->", spellCount);
            if (input == 1) {
                damage = 10;
            } else if (input == 2) {
                damage = 20;
            }else if (input == 3) {
                damage = 30;
            }else if (input == 4) {
                damage = 40;
            }
        }
        return damage;      }


}
