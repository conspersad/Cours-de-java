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
    public int ennemy_choose_speel(){
        int damage;
        if (Math.random() > 0.5){
            System.out.println("Your ennemy use Wingardium Leviosa. \n");
            damage=15;
        }else{
            System.out.println("Your ennemy use Accio. \n");
            damage=20;
        }
        return damage;
    }
    @Override
    public int attack() {
        int damage=0;
        if((Execution.level == 1 )||(Execution.level == 2)  || (Execution.level ==3)){
        damage = (int)(Math.random() * 10) + 1;}
        else {
            if((Execution.enemy.name=="Voldemort")){
                damage = ennemy_choose_speel()+25;
            }else
                damage = ennemy_choose_speel();

        }
        return damage;
    }

    @Override
    public int defend() {
        int damage;
        if(Execution.wizard.house=="Ravenclaw"){
        if (Math.random() > 0.8) {
           damage = 0;
            return damage;
        } else {
            damage = 1;
            return damage;
        }}else
            if (Math.random() > 0.6) {
                damage = 0;
                return damage;
            } else {
                damage = 1;
                return damage;
            }
    }
    public void setHp (int newHp){
            this.hp = newHp;
        }
    public static int verifierPreparationFeuArtifice(boolean preparationEnCours) {
        int dommages = 0;
        if (preparationEnCours==true) {

            if (Math.random() > 0.6) {
                 dommages = 25;}
            else{dommages = 0; }
            } else{
            System.out.println("Dolores : I don't know why did you call me but it feels like you are preparing something !");
        }
        return dommages;
    }
}





