import java.util.List;
import java.lang.String;
import java.util.ArrayList;

public class Wizard extends Character {
    public String name;
    public static int maxHp;
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
    }


    @Override
    public int attack() {
        // L'ennemi a un niveau de difficulté de 1
        int enemyLevel = 1;

        // Calcule les dégâts infligés par le sortilège du sorcier
        int damage = 0;
        for (Spell spell : knownSpells) {
            if (spell.getLevel() == enemyLevel) {
                damage = spell.getDamage();
                break;
            }
        }

        // Si le sorcier n'a pas de sortilège adapté, retourne 0 (pas de dégâts infligés)
        if (damage == 0) {
            return 0;
        }

        // Calcule les dégâts finaux en prenant en compte la puissance de la baguette du sorcier
        int finalDamage = damage * wand;

        // Retourne les dégâts finaux
        return finalDamage;
    }
    public double getLuck() {
        return Math.random();
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
            return 10; // 10 points de dégâts sont infligés
        }
    }}
