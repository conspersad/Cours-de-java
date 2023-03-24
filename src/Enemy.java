public class Enemy extends AbstractEnemy{
    public Enemy(int maxHp, int xp) {
        super(maxHp, xp);
    }

    @Override
    public int attack() {
        return 0;
    }
}
