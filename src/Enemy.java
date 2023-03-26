public class Enemy extends AbstractEnemy{

    public static int hp;
    public static int xp;
    String name;
    public Enemy(String name,int xp,int maxHp)
    {
        super(maxHp,xp);
        this.xp=xp;
        this.name=name;
        hp=maxHp;
    }
    public boolean isAlive() {

        return hp > 0;
    }
    @Override
    public int attack() {
        int damage = (int)(Math.random() * 10) + 1; // l'ennemi inflige entre 1 et 10 points de dégâts
        System.out.println(name + " attaque le sorcier et inflige " + damage + " points de dégâts!");
        return damage;
    }

    @Override
    public int defend() {
        int damage;
        if (Math.random() > 0.1) {
            System.out.println(Execution.enemy.name + " dodged the attack!");
            damage = 0;
            return damage;
        } else {
            System.out.println(Execution.enemy.name + " was hit!");
            damage = 10;
            return damage; // l'ennemi subit 10 points de dégâts
        }
    }
    public void setHp ( int newHp){
        // Vérifier que la nouvelle valeur de points de vie est positive
        if (newHp < 0) {
            System.out.println("Error: the new value of HP must be positive");
        } else {
            // Mettre à jour la valeur de points de vie avec la nouvelle valeur
            this.hp = newHp;
        }
    }

}
