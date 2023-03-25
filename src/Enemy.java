public class Enemy extends AbstractEnemy{
    public static int maxHp;
    public static int hp;
    public int xp;
    String name;
    public Enemy(String name)
    {
        super(100,0);
        this.name=name;
    }

    @Override
    public int attack() {
        int damage = 0;
        // Récupération des informations du sorcier
        int wizardHp = Execution.wizard.maxHp;
        int wizardDefense = Execution.wizard.defend();
        // Calcul des dégâts infligés
        damage = (int) (Math.random() * 10) + 10 - wizardDefense;
        // Vérification que les dégâts infligés sont positifs
        if (damage < 0) {
            damage = 0;
        }
        // Réduction des points de vie du sorcier
        Execution.wizard.maxHp=wizardHp - damage;
        return damage;
    }

    @Override
    public int defend() {
        int damage=0;
            // Récupération des informations de l'ennemi
            int enemyHp = Execution.enemy.maxHp;
            int enemyDefense =  Execution.enemy.defend();
            // Calcul des dégâts réduits
            int reducedDamage = (int) (damage * (1 - enemyDefense / 100.0));
            // Utilisation d'une armure pour réduire les dégâts subis
           /* Armors armors = new Armors();
            Armor armor = armors.getArmor();
            if (armor != null) {
                int armorReducedDamage = (int) (reducedDamage * armor.getReduction());
                reducedDamage -= armorReducedDamage;
                System.out.println("L'ennemi a utilisé une armure " + armor.getName() + " pour réduire les dégâts subis de " + armorReducedDamage + " points.");
            }*/
            // Réduction des points de vie de l'ennemi
            maxHp=(enemyHp - reducedDamage);
            return reducedDamage;

    }
    public boolean isAlive() {
        return hp > 0;
    }
}
