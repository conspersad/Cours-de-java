public class Enemy extends AbstractEnemy{

    int playerXp;
    String name;
    public Enemy(String name,int playerXp)
    {
        super(100,0,name);

    }

    @Override
    public int attack() {
        return 0;
    }
}
