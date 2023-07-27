package units;

import units.abstractclass.AbsoluteHero;
import units.helpers.States;

import java.util.ArrayList;

import static units.helpers.States.*;

// Класс Крестьянин
public class Countryman extends AbsoluteHero {
    
    private int musclePower; // физическая сила
    private int maxMusclePower;

    public Countryman(int x, int y) {
        super(getName(),
            Countryman.r.nextInt(100, 200), new int[]{0, 0}, x, y, 3, States.Busy);
        this.maxMusclePower = Countryman.r.nextInt(50, 150);
        this.musclePower = maxMusclePower;
    }

    @Override
    public String getInfo() {
        return getClass().getName().substring(6)
                + " " + name + " \u2764:" + hp + " \u2691:" + coordinates + " \u2655:" + initiative + " \u2605:" + state;
    }

    @Override
    public void step(ArrayList<AbsoluteHero> enemyArmy, ArrayList<AbsoluteHero> ownArmy){
        if (hp > 0) state = Ready;
    }
}
