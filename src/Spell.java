import java.lang.String;
import java.util.Arrays;

public class Spell extends AbstractSpeel{
    private static String[] knownSpells;

    public Spell(int level, int damage, String[] knownSpells) {
        super(level, damage);
        Spell.knownSpells = knownSpells;
    }

    public static int getDamage() {
        if(Execution.level==1 )
        {
            damage =10;
        }
        return damage;
    }


}
