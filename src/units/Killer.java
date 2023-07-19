package units;

import java.util.ArrayList;

// Класс Снайпер
public class Killer extends Shooter { 
    
    private int arrow; // стрелы

    public static String setName(){
        return String.format("Hero_Killer #%d", ++Killer.number);
    }

    public Killer(int x, int y, int initiative) {
        super(setName(), x, y, initiative);
        this.arrow = Killer.r.nextInt(50, 100);

    }

    // Метод война
    public void war(int hour) {
        super.war(hour);
        this.arrow -= hour * 5;
    }

    @Override
    public String getInfo() {
        return getClass().getName() + " " + name + " " + coordinates + " " + hp + " " + arrow;
    }

    @Override
    public void step(ArrayList<AbsoluteHero> enemyArmy, ArrayList<AbsoluteHero> ownArmy) {
        if (this.hp == 0 || this.arrow == 0) {return;}
        AbsoluteHero nearestEnemy = findNearest(enemyArmy);
        attack(nearestEnemy);
        for(AbsoluteHero hero: ownArmy){
            if (hero.getClass() == Countryman.class) return;
        }
        this.arrow -= 1;
    }
}
