package units;// Класс Базовый Герой
import java.util.ArrayList;
import java.util.Random;

public abstract class AbsoluteHero implements AppInterface{

    protected static int number;
    protected static Random r;

    protected String name;
    protected int hp; // жизненная сила
    protected int maxHp;

    public int initiative;
    protected int money; // деньги
    protected int hunger; // голод

    protected Coordinates coordinates;

    static {
        AbsoluteHero.number = 0;
        AbsoluteHero.r = new Random();
    }

    public AbsoluteHero(String name, int hp, int money, int hunger, int x, int y, int initiative) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.money = money;
        this.hunger = hunger;
        this.coordinates = new Coordinates(x, y);
        this.initiative = initiative;
     }

    public AbsoluteHero(int x, int y, int initiative) {
        this(String.format("Hero_Base #%d", ++AbsoluteHero.number), 
        AbsoluteHero.r.nextInt(100, 200),
        AbsoluteHero.r.nextInt(500, 1000),
        AbsoluteHero.r.nextInt(0, 50), x, y, initiative);
    }

    @Override
    public String getInfo() {
        return getClass().getName() + " " + name + " " + coordinates;
    }

    // Метод для поиска ближайшего противника
    public AbsoluteHero findNearest (ArrayList<AbsoluteHero> enemyArmy){
        AbsoluteHero nearest = enemyArmy.get(0);
        for (int i = 1; i < enemyArmy.size() ; i++) {
            if (Coordinates.distance(coordinates.x, coordinates.y, enemyArmy.get(i)) <
                    Coordinates.distance(coordinates.x, coordinates.y, nearest)){
                nearest = enemyArmy.get(i);
            }
        }
        return nearest;
    }

    // Метод питание
    public void feed(int food) {
        this.hunger = this.hunger - food > 0 ? this.hunger : 0;
    }

    // Метод лечение
    public void healed(int Hp) {
        this.hp = Hp + this.hp > this.maxHp ? this.maxHp : Hp + this.hp;
    }

    // Метод денежные потери
    public void moneyOff(int money) {
        if (this.money - money > 0) {
            this.money -= money;
        }
        else { this.money = 0; }
    }

    // Метод получения травм
    public void GetDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        else { die(); }
    }

    // Метод смерти
    protected void die() {
        System.out.println("You are dead");
    }

    // Метод атаки
    public void attack(AbsoluteHero target) {
        int damage = AbsoluteHero.r.nextInt(10, 20);
        target.GetDamage(damage);
    }
}
