public class AbstractEnemy extends Character{
    public int maxHp,hp,xp;
    public String name;

    public AbstractEnemy(int maxHp, int xp,String name) {
        super(maxHp, xp);
        this.name=name;
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }
}
