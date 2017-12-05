package p03_05_BarracksWars.models.units;

public class Gunner extends AbstractUnit {
    private static final int ARCHER_HEALHT = 20;
    private static final int ARCHER_DAMAGE = 20;

    public Gunner() {
        super(ARCHER_HEALHT, ARCHER_DAMAGE);
    }
}
