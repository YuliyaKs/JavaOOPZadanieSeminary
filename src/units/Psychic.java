package units;

// Абстрактный класс Жрецы
public abstract class Psychic extends AbsoluteHero {
    
    public int mana;  // магия
    public int maxMana;
    public static String fio;

    public static String setName(){
        return fio = String.format("Hero_Psychic #%d", ++Psychic.number);
    }

    public Psychic(String fio, int x, int y) {
        super(fio, Psychic.r.nextInt(100, 200),
            Psychic.r.nextInt(500, 1000), 
            Psychic.r.nextInt(0, 50), x, y);
        this.maxMana = Countryman.r.nextInt(50, 150);
        this.mana = maxMana;
    }
    
    // Метод обряды
    public void ceremony(int hour) {
        super.money += hour * 100;
        super.hunger += hour * 10;
        if (hunger > 100) super.die();
        this.mana -= hour * 10;
    }
}
