import java.lang.System;
import java.lang.String;

public class Spell extends AbstractSpeel{
    private String[] knownSpells ;
    public Spell(String knownSpells, int level) {
        super(level);
        this.knownSpells = new String[]{knownSpells};
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
