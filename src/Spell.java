import java.lang.String;
import java.util.Arrays;

public class Spell extends AbstractSpeel{
    public static String[] knownSpells ={} ;
    public int level;
    public int damage;

    public Spell(int level, int damage, String[] knownSpells) {
        super(level, damage);
        this.knownSpells =knownSpells;
    }

    public int getLevel() {
        return level;
    }

    public int getDamage() {
        return damage;
    }

    public static int CastSpeel() {
        if(Execution.level == 1)
        {
            knownSpells[0]= Arrays.toString(new String[]{"Wingardium Leviosa"});
            Execution.wizard.xp=10;
        } else if (Execution.level == 2) {
            System.out.println("You need to practise a little bit more young wizard");
        }
        return Execution.wizard.xp;

    }
}
