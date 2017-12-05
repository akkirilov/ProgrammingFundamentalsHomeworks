package p03_05_BarracksWars.models.units;

public class Horseman extends AbstractUnit {
    private static final int ARCHER_HEALHT = 50;
    private static final int ARCHER_DAMAGE = 10;

    public Horseman() {
        super(ARCHER_HEALHT, ARCHER_DAMAGE);
    }
}
