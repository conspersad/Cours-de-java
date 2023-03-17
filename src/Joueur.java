import java.lang.System;
import java.lang.String;
import java.util.Scanner;

public class Joueur extends Character{
    public int numAtaUpgrades, numDefUpgrades;
    static Scanner scanner = new Scanner(System.in);
    Pet[] pet = Pet.values();
    public String[] attUpgrades ={"Strenght","Power","Might","Godlike Strenght"};
    public String[]  defUpgrades ={"Heavy bones","Stoneskin","Scale Armor","Holy aura"};

    public Joueur(String name){
       super(name, 100,0);
       //mettre les maj à 0
       this.numAtaUpgrades =0;
       this.numDefUpgrades =0;
       //laisse le personnage choisir un trait quand il crée un nouveaux personnage
        chooseTrait();
    }
    public  int attack(){
        return  0;
    }
    public int defend(){
        return 0;
    }

    public void chooseTrait(){
        Execution.clearconsole();
        Execution.printHeading("Please, choose your compagnon for the adventures");
        System.out.println("(0) Owl");
        System.out.println("(1) Rat");
        System.out.println("(2) Cat");
        System.out.println("(3) Toad");
        System.out.println("(4) Dog");
        int pet_value = scanner.nextInt();
        System.out.println("Nice you have a new "+ pet[ pet_value]);
        wand.choose_wand_size();
        wand.choose_core();
        House.your_house();

       /* Execution.printHeading("Choose a trait :");
        System.out.println("(1)" + attUpgrades[numAtaUpgrades]);
        System.out.println("(2)" + defUpgrades[numDefUpgrades]);
        //get the player choice
        int input = Execution.readInt("->",2);
        Execution.clearconsole();
        //deal with both cases
        if (input == 1.) {
            Execution.printHeading("you chose" + attUpgrades[numAtaUpgrades] +"!");
            numAtaUpgrades++;
        }else{
            Execution.printHeading("you chose" + defUpgrades[numDefUpgrades] +"!");
            numDefUpgrades++;
        }*/
        Execution.anythingtocontinue();

    }
}
