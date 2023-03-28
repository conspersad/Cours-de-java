import java.lang.String;


public class Spell extends AbstractSpeel{
    static String[] knownSpells;

    public Spell(int level, int damage, String[] knownSpells) {
        super(level, damage);
        Spell.knownSpells = knownSpells;
    }

    public static int getDamage(int spell) {
        if(spell==1)
        {
            damage=10;
        }else if(spell==2){
            damage=15;
        }
        return damage;
    }


}
