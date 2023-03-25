public class Enemy extends AbstractEnemy{

    int playerXp;
    String name;
    public Enemy(String name,int playerXp)
    {
        super(100,0,name);

    }

    @Override
    public int attack() {
        int damage = 0;
        // Récupération des informations du sorcier
        int wizardHp = Wizard.getHp();
        int wizardDefense = Wizard.getDefense();
        // Calcul des dégâts infligés
        damage = (int) (Math.random() * 10) + 10 - wizardDefense;
        // Vérification que les dégâts infligés sont positifs
        if (damage < 0) {
            damage = 0;
        }
        // Réduction des points de vie du sorcier
        Wizard.setHp(wizardHp - damage);
        return damage;
    }

    @Override
    public int defend() {
        public int defense(int damage) {
            // Récupération des informations de l'ennemi
            int enemyHp = getHp();
            int enemyDefense = getDefense();
            // Calcul des dégâts réduits
            int reducedDamage = (int) (damage * (1 - enemyDefense / 100.0));
            // Utilisation d'une armure pour réduire les dégâts subis
            Armors armors = new Armors();
            Armor armor = armors.getArmor();
            if (armor != null) {
                int armorReducedDamage = (int) (reducedDamage * armor.getReduction());
                reducedDamage -= armorReducedDamage;
                System.out.println("L'ennemi a utilisé une armure " + armor.getName() + " pour réduire les dégâts subis de " + armorReducedDamage + " points.");
            }
            // Réduction des points de vie de l'ennemi
            setHp(enemyHp - reducedDamage);
            return reducedDamage;
        }
    }
}
