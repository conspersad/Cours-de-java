import java.util.Scanner;
import java.lang.System;
import java.lang.String;
public class Wizard extends Character {
    public String name;
    Pet pet;
    int wand;
    String house;
    static Scanner scanner = new Scanner(System.in);
    public Wizard(String name, Pet pet, int wand, String house){
        this.name=name;
        this.pet=pet;
        this.wand=wand;
        this.house=house;
    }

    public void Defend(){

    };
    //overide
    public  int attack(){
        return 0;
    }

}

