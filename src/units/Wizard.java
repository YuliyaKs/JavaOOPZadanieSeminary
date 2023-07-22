package units;

import units.abstractclass.Psychic;
import units.helpers.States;

// Класс Колдун
public class Wizard extends Psychic {

    private int elixir;
    private int medicament;

    public Wizard(int x, int y) {
        super(new int[]{-5, -5}, x, y, 6, States.Ready);
        this.elixir = Wizard.r.nextInt(0, 100);
    }
}
