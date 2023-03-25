import java.lang.String;

public class Spell extends AbstractSpeel{
    public static String[] knownSpells ={"Wingardium Leviosa"} ;
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
        return 0;

    }
}
