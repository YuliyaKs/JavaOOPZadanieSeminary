package units.abstractclass;

import units.helpers.States;

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
    public String getInfo() {
        return getClass().getName().substring(6)
                + " " + name + " \u2661:" + hp + " \u2299:" + coordinates + " \u2655:" + initiative + " \u2605:" + state;
    }
}
