package units;

import java.util.ArrayList;

// Класс Разбойник
public class Bandit extends Soldier{
    
    private int blade; // ножи

    public static String setName(){
        return String.format("Hero_Bandit #%d", ++Killer.number);
    }

    public Bandit(int x, int y, int initiative) {
        super(setName(), x, y, initiative);
        this.blade = Bandit.r.nextInt(0, 100);
    }

    // Метод ограбление
    public void takeMoney(int hour, AbsoluteHero target) {
        super.money += hour * 100;
        super.hunger += hour * 30;
        if (hunger > 100) super.die();
        super.speed -= hour * 10;
        this.blade -= hour * 5;
        target.moneyOff(hour*100);
    }

    @Override
    public String getInfo() {
        return getClass().getName() + " " + name + " " + coordinates + " " + hp;
    }

    @Override
    public void step(ArrayList<AbsoluteHero> enemyArmy, ArrayList<AbsoluteHero> ownArmy){}
}
