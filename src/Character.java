public abstract class Character {
    public int maxHp;
    public static int xp;

    //fonction de tout les personnages
    public Character(int maxHp,int xp){
        this.maxHp=maxHp;
        this.xp=xp;
    }
    public abstract  int attack();

    public abstract int defend();
    // public abstract int defend();

}
