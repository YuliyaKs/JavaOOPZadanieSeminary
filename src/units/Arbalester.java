package units;

// Класс Арбалетчик
public class Arbalester extends Shooter{
    
    private int dart; // стрелы

    public static String setName(){
        return String.format("Hero_Arbalester #%d", ++Arbalester.number);
    }

    public Arbalester(int x, int y) {
        super(setName(), x, y);
        this.dart = Arbalester.r.nextInt(0, 100);
    }

    // Метод война
    public void war(int hour) {
        super.war(hour);
        this.dart -= hour * 5;
    }

    @Override
    public String getInfo() {
        return getClass().getName() + " " + name + " " + coordinates;
    }

    @Override
    public void step(){}
}

