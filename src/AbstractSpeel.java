public abstract class AbstractSpeel {
    protected String name;
    protected int level;
    public AbstractSpeel(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public abstract void castSpell();
}
