package units;

import java.util.ArrayList;

// Класс Арбалетчик
public class Arbalester extends Shooter{
    
    private int dart; // стрелы

    public static String setName(){
        return String.format("Hero_Arbalester #%d", ++Arbalester.number);
    }

    public Arbalester(int x, int y, int initianive) {
        super(setName(), x, y, initianive);
        this.dart = Arbalester.r.nextInt(0, 100);
    }

    // Метод война
    public void war(int hour) {
        super.war(hour);
        this.dart -= hour * 5;
    }

    @Override
    public String getInfo() {
        return getClass().getName() + " " + name + " " + coordinates + " " + hp;
    }

    @Override
    public void step(ArrayList<AbsoluteHero> enemyArmy, ArrayList<AbsoluteHero> ownArmy){}
}

