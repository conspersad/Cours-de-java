import java.util.List;
import java.lang.String;
import java.util.ArrayList;

public class Wizard extends Character {
    public String name;
    public static int nbr_de_potion=3;
    public static int hp;
    public int xp;
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
        hp=maxHp;
    }

    @Override
    public int attack() {
        // Calcule les dégâts infligés par le sortilège du sorcier
        int damage,finalDamage;
        damage = Execution.speel.damage;

        if(Execution.wizard.house=="Slytherin")
        {
            finalDamage = damage +10;
            return finalDamage;
        }else
            finalDamage = damage;
        return finalDamage ;
    }
    public double getLuck() {
        return Math.random();
    }
    public boolean isAlive() {
        return hp > 0;
    }
    @Override
    public int defend() {
        // calcul de la probabilité de défense en fonction de la chance du sorcier
        double defenseProbability = 0.5 + this.getLuck() / 20.0;

        // génération d'un nombre aléatoire entre 0 et 1 pour déterminer si le sorcier réussit à esquiver l'attaque
        double random = Math.random();

        if (random < defenseProbability) {
            System.out.println("You successfully defended against the attack!");
            return 0; // aucun dégât n'est infligé
        } else {
            System.out.println("You failed to defend against the attack!");
            return 1 ; // 10 points de dégâts sont infligés
        }
    }
    public void usePotion() {

        while(nbr_de_potion<3){
        if((Execution.wizard.house=="Hufflepuff")&&(Execution.wizard.hp<100))
        {
            int healed = 20;
            Execution.wizard.setHp(Execution.wizard.hp+healed);
            System.out.println( Execution.wizard.name+ " get " + healed + " points of life.");
            nbr_de_potion=nbr_de_potion-1;
        }else if(((Execution.wizard.house=="Gryffindor")||(Execution.wizard.house=="Ravenclaw")||(Execution.wizard.house=="Slytherin"))&&(Execution.wizard.hp<100))  {
            int healed = 10;
            Execution.wizard.setHp(Execution.wizard.hp+healed);
            System.out.println( Execution.wizard.name+ " get " + healed + " points of life.");
            nbr_de_potion=nbr_de_potion-1;}
         else{
            System.out.println( Execution.wizard.name+ " have enough life !");
        }}}
    public void setHp (int newHp){
        this.hp = newHp;
    }

}


