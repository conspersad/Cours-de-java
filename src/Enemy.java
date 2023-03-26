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
        return damage;
    }

    @Override
    public int defend() {
        int damage;
        if (Math.random() > 0.7) {
            damage = 0;
            return damage;
        } else {
            damage = 2;
            return damage; // l'ennemi subit 10 points de dégâts
        }
    }
    public void setHp (int newHp){
            this.hp = newHp;
    }

}
