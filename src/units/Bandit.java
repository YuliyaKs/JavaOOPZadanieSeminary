package units;

import units.abstractclass.AbsoluteHero;
import units.abstractclass.Soldier;
import units.helpers.States;

import java.util.ArrayList;

// Класс Разбойник
public class Bandit extends Soldier {
    
    public Bandit(int x, int y) {
        super(new int[]{2, 6}, x, y, 8, States.Ready);
    }
}
