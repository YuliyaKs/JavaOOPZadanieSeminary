package units.abstractclass;

import units.Countryman;
import units.helpers.States;

import java.util.ArrayList;

// Абстрактный класс Воины
public abstract class Soldier extends AbsoluteHero {

    public int speed; // скорость
    public int maxSpeed;

    public Soldier(int[] damage, int x, int y, int initiative, States state) {
        super(getName(), Soldier.r.nextInt(100, 200), damage, x, y, initiative, state);
        this.maxSpeed = Soldier.r.nextInt(50, 150);
        this.speed = maxSpeed;
    }

    @Override
    public void step(ArrayList<AbsoluteHero> enemyArmy, ArrayList<AbsoluteHero> ownArmy) {
        if (this.hp == 0) {return;}
        AbsoluteHero nearestEnemy = this.findNearest(enemyArmy);
        int[] stepCoordin = coordinates.stepCoord(nearestEnemy.coordinates);
        boolean flag = false;
        for (int i = 0; i < enemyArmy.size(); i++) {
            if (enemyArmy.get(i).coordinates.x == stepCoordin[0] & enemyArmy.get(i).coordinates.y == stepCoordin[1] &
                    enemyArmy.get(i).state != States.Die) {
                this.attack(nearestEnemy, (this.damage[0] + this.damage[1]) / 2);
                flag = true;
            } else if (ownArmy.get(i).coordinates.x == stepCoordin[0] & ownArmy.get(i).coordinates.y == stepCoordin[1] &
                    ownArmy.get(i).state != States.Die) {
                flag = true;
            }
        }
        if (!flag) {
                if (stepCoordin[0] > 0 & stepCoordin[0] < 11) this.coordinates.x = stepCoordin[0];
                if (stepCoordin[1] > 0 & stepCoordin[1] < 11) this.coordinates.y = stepCoordin[1];
        }
    }

    @Override
    public String getInfo() {
        return getClass().getName().substring(6)
                + " " + name + " \u2764:" + hp + " \u2691:" + coordinates + " \u2655:" + initiative + " \u2605:" + state;
    }
}
