package units;

// Абстрактный класс Воины
public abstract class Soldier extends AbsoluteHero{

    public int speed; // скорость
    public int maxSpeed;
    public static String fio;
    
    public static String setName(){
        return fio = String.format("Hero_Soldier #%d", ++Soldier.number);
    }

    public Soldier(String fio, int x, int y) {
        super(fio, Soldier.r.nextInt(100, 200),
            Soldier.r.nextInt(500, 1000), 
            Soldier.r.nextInt(0, 50), x, y);
        this.maxSpeed = Soldier.r.nextInt(50, 150);
        this.speed = maxSpeed;
    }
}
