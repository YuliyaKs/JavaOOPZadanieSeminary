package units;

// Класс Копейщик
public class Pikeman extends Soldier {
    
    private int pike; // копья

    public static String setName(){
        return String.format("Hero_Pikeman #%d", ++Killer.number);
    }

    public Pikeman(int x, int y) {
        super(setName(), x, y);
        this.pike = Pikeman.r.nextInt(0, 100);
    }

      // Метод война
    public void war(int hour) {
        super.money += hour * 100;
        super.hunger += hour * 10;
        if (hunger > 100) super.die();
        super.speed -= hour * 10;
        this.pike -= hour * 5;
    }

    @Override
    public String getInfo() {
        return getClass().getName() + " " + name + " " + coordinates;
    }

    @Override
    public void step(){}
}