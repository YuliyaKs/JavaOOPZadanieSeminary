package units;

// Абстрактный класс Стрелки
public abstract class Shooter extends AbsoluteHero{

    public int accuracy; // меткость
    public int maxAccuracy;
    public static String fio;
    
    public static String setName(){
        return fio = String.format("Hero_Shooter #%d %d", ++Shooter.number, Shooter.class);
    }

    public Shooter(String fio, int x, int y, int initiative) {
        super(fio, Shooter.r.nextInt(100, 200),
            Shooter.r.nextInt(500, 1000), 
            Shooter.r.nextInt(0, 50), x, y, initiative);
        this.maxAccuracy = Shooter.r.nextInt(50, 150);
        this.accuracy = maxAccuracy;
    }
    
    // Метод война
    public void war(int hour) {
        super.money += hour * 100;
        super.hunger += hour * 10;
        if (hunger > 100) super.die();
        this.accuracy -= hour * 10;
    }
}