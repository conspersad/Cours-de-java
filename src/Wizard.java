import java.util.List;
import java.util.Scanner;
import java.lang.System;
import java.lang.String;
import java.util.ArrayList;
import java.util.LinkedList;
public class Wizard extends Character {
    public String name;
    Pet pet;
    int wand;
    String house;
    List<Spell> knownSpells = new ArrayList<>();
    //List<Potion> maListe = new ArrayList<Integer>();
    static Scanner scanner = new Scanner(System.in);
    public Wizard(String name, Pet pet, int wand, String house){
        this.name=name;
        this.pet=pet;
        this.wand=wand;
        this.house=house;
    }

    public void Defend(){

    };
    @Override
    public  int attack(){
        return 0;
    }

}

