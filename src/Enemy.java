public class Enemy extends AbstractEnemy{

    int playerXp;
    String name;
    public Enemy(String name,int playerXp)
    {
        super((int)(Math.random()*playerXp + playerXp/3+5),(int)(Math.random()*(playerXp/4+2)+1));
        this.playerXp=playerXp;
        this.name=name;
    }

    @Override
    public int attack() {
        return 0;
    }
}
