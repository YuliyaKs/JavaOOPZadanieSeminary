package units;

import units.abstractclass.Shooter;
import units.helpers.States;

// Класс Снайпер
public class Killer extends Shooter {
    
    public Killer(int x, int y) {
        super(new int[] {3, 7}, x, y, 10, States.Ready);
    }
}
