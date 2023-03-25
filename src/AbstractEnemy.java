public class AbstractEnemy extends Character{
    public int maxHp,hp,xp;
    public String name;

    public AbstractEnemy(int maxHp, int xp) {
        super(maxHp, xp);
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
