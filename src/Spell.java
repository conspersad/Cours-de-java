import java.lang.System;
import java.lang.String;

public class Spell extends AbstractSpeel{
    private final String[] knownSpells ;
    public Spell(String name, int level, String[] knownSpells) {
        super(name, level);
        this.knownSpells = knownSpells;
    }

    @Override
    public void castSpell() {
        if (level == 1)
            knownSpells[1] = "Wingardium Leviosa";
        else {
            System.out.println("You need to continue your training");
        }
    }

}
