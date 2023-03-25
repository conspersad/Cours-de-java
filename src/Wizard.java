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

        int damage = 0;
        // Récupération des informations de l'ennemi
        int enemyHp = enemy.getHp();
        int enemyDefense = enemy.getDefense();
        // Calcul des dégâts infligés
        damage = (int) (Math.random() * 10) + 10 - enemyDefense;
        // Vérification que les dégâts infligés sont positifs
        if (damage < 0) {
            damage = 0;
        }
        // Utilisation d'une potion pour augmenter les dégâts infligés
        Potions potions = new Potions();
        Potion potion = potions.getPotion();
        if (potion != null) {
            int potionDamage = (int) (damage * potion.getBoost());
            damage += potionDamage;
            System.out.println("Vous avez utilisé une potion " + potion.getName() + " pour augmenter vos dégâts de " + potionDamage + " points.");
        }
        // Réduction des points de vie de l'ennemi
        enemy.setHp(enemyHp - damage);
        return damage;
    }

    @Override
    public int defend() {
        public int defense(int damage) {
            public int defense(int damage) {
                // Récupération des informations du sorcier
                int sorcierHp = getHp();
                int sorcierDefense = getDefense();
                // Calcul des dégâts réduits
                int reducedDamage = (int) (damage * (1 - sorcierDefense / 100.0));
                // Utilisation d'une potion de défense pour réduire les dégâts subis
                Potions potions = new Potions();
                Potion potion = potions.getPotion("defense");
                if (potion != null) {
                    int potionReducedDamage = (int) (reducedDamage * potion.getBoost());
                    reducedDamage -= potionReducedDamage;
                    System.out.println("Vous avez utilisé une potion de défense " + potion.getName() + " pour réduire les dégâts subis de " + potionReducedDamage + " points.");
                }
                // Réduction des points de vie du sorcier
                setHp(sorcierHp - reducedDamage);
                return reducedDamage;
            }
        }
    }

}

