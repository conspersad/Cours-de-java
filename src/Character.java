public abstract class Character {
    //attribu de tout les personnages
    public String name;
    public int maxHp, hp,xp;

    // constructeur du personnage
    public Character(String name,int maxHp,int xp){
        this.name=name;
        this.maxHp = maxHp;
        this.xp =xp;
        this.hp=hp;

    }
    //fonction de tout les personnages
    public abstract  int attack();
    public abstract int defend();

}
