package units;

import units.abstractclass.AbsoluteHero;
import units.abstractclass.Soldier;
import units.helpers.States;

import java.util.ArrayList;

// Класс Копейщик
public class Pikeman extends Soldier {
    
    private int pike; // копья

    public Pikeman(int x, int y) {
        super(new int[]{2, 6}, x, y, 7, States.Ready);
        this.pike = Pikeman.r.nextInt(0, 100);
    }

    @Override
    public void step(ArrayList<AbsoluteHero> enemyArmy, ArrayList<AbsoluteHero> ownArmy){}
}