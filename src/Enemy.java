public class Enemy extends AbstractEnemy{
    public static int maxHp;
    public static int hp;
    public int xp;
    String name;
    public Enemy(String name,int maxHp,int xp)
    {
        super(maxHp,xp);
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
    public int defend(int damage) {
        if (Math.random() < 0.1) { // probabilité de 50% de ne pas être touché
            System.out.println(name + " dodged the attack!");
            return 0;
        } else {
            System.out.println(name + " was hit!");
            return 10; // l'ennemi subit 10 points de dégâts
        }

    }
}
