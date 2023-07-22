package units;

import units.abstractclass.Psychic;
import units.helpers.States;

// Класс Монах
public class Monastic extends Psychic {

    private int miro;

    public Monastic(int x, int y) {
        super(new int[]{-5, -5}, x, y, 5, States.Ready);
        this.miro = Monastic.r.nextInt(0, 100);
    }
}
