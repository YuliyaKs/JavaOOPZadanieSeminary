package units.abstractclass;

import units.Countryman;
import units.helpers.States;

import java.util.ArrayList;

// Абстрактный класс Стрелки
public abstract class Shooter extends AbsoluteHero {

    private int dart; // стрелы
    public int accuracy; // меткость
    public int maxAccuracy;

    public Shooter(int[] damage, int x, int y, int initiative, States state) {
        super(getName(), Shooter.r.nextInt(100, 200), damage, x, y, initiative, state);
        this.maxAccuracy = Shooter.r.nextInt(50, 150);
        this.accuracy = maxAccuracy;
        this.dart = Shooter.r.nextInt(50, 100);
    }
    
    // Метод ход
    @Override
    public void step(ArrayList<AbsoluteHero> enemyArmy, ArrayList<AbsoluteHero> ownArmy) {
        if (this.hp == 0 || this.dart == 0) {return;}
        AbsoluteHero nearestEnemy = this.findNearest(enemyArmy);
        this.attack(nearestEnemy, (this.damage[0] + this.damage[1])/2);
        for(AbsoluteHero hero: ownArmy){
            if (hero.getClass().equals(Countryman.class) && hero.state.equals(States.Ready)) {
                hero.state = States.Busy;
                return;
            }
        }
        this.dart -= 1;
    }

    @Override
    public String getInfo() {
        return getClass().getName().substring(6)
                + " " + name + " \u2661:" + hp + " \u2299:" + coordinates + " \u2655:" + initiative + " \u2605:" + state + " \u21F6:" + dart;
    }
}