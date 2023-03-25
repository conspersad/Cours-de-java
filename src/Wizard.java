import java.util.List;
import java.lang.String;
import java.util.ArrayList;

public class Wizard extends Character {
    public String name;
    public int maxHp,hp,xp;
    Pet pet;
    int wand;
    String house;

    List<Spell> knownSpells = new ArrayList<>();
    //List<Potion> maListe = new ArrayList<Integer>();

    public Wizard(String name, Pet pet, int wand, String house, int maxHp,int xp){
        super(maxHp,xp);
        this.name=name;
        this.pet=pet;
        this.wand=wand;
        this.house=house;
    }

    public void Defend(){

    };
    @Override
    public  int attack(){

        return (int) (Math.random()*(xp/4+3)+ xp/10 );
    }

    @Override
    public int defend() {
        return 0;
    }

}

