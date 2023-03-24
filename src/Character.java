public abstract class Character {
    public int maxHp=100;
    public int hp;
    public static int xp;

    //fonction de tout les personnages
    public Character(int maxHp,int xp){
        this.maxHp=maxHp;
        this.xp=xp;
    }
    public abstract  int attack();
   // public abstract int defend();

}
