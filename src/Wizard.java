import java.lang.String;

public class Wizard extends Character {
    public String name;
    public static int nbr_de_potion=3;
    public static int hp;
    public int xp;
    Pet pet;
    int wand;
    String house;

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
        int spell = Execution.speel;
        // Calcule les dégâts infligés par le sortilège du sorcier
        int finalDamage;
        int damage = Spell.getDamage(spell);

        if(Execution.wizard.house.equals("Slytherin"))
        {
            finalDamage = damage + 5;
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
            System.out.println("You successfully defended against the attack!\n");
            return 0; // aucun dégât n'est infligé
        } else {
            System.out.println("You failed to defend against the attack!\n");
            if (Execution.wizard.house.equals("Gryffindor")) {
                return 1/2; // 10 points de dégâts sont infligés
            } else return 1;
        }
    }

    public void setHp (int newHp){
        this.hp = newHp;
    }

}


