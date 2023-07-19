package units;

import java.util.ArrayList;

// Класс Крестьянин
public class Countryman extends AbsoluteHero{
    
    private int musclePower; // физическая сила
    private int maxMusclePower;
    private int tool; // инструменты

    public Countryman(int x, int y, int initiative) {
        super(String.format("Hero_Countryman #%d", ++Countryman.number),
            Countryman.r.nextInt(100, 200),
            Countryman.r.nextInt(500, 1000), 
            Countryman.r.nextInt(0, 50), x, y, initiative);
        this.maxMusclePower = Countryman.r.nextInt(50, 150);
        this.musclePower = maxMusclePower;
        this.tool = Countryman.r.nextInt(0, 100);
    }

    // Метод земледелие
    public void agronomy(int hour) {
        super.money += hour * 100;
        super.hunger += hour * 10;
        if (hunger > 100) super.die();
        this.musclePower -= hour * 10;
        this.tool -= hour * 5;
    }

    @Override
    public String getInfo() {
        return getClass().getName() + " " + name + " " + coordinates + " " + hp;
    }

    @Override
    public void step(ArrayList<AbsoluteHero> enemyArmy, ArrayList<AbsoluteHero> ownArmy){}
}
