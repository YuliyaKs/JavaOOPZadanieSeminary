package units;// Класс Базовый Герой
import java.util.ArrayList;
import java.util.Random;

public abstract class AbsoluteHero implements AppInterface{

    protected static int number;
    protected static Random r;

    protected String name;
    protected int hp; // жизненная сила
    protected int maxHp;
    protected int money; // деньги
    protected int hunger; // голод
    protected Coordinates coordinates;

    static {
        AbsoluteHero.number = 0;
        AbsoluteHero.r = new Random();
    }

    public AbsoluteHero(String name, int hp, int money, int hunger, int x, int y) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.money = money;
        this.hunger = hunger;
        this.coordinates = new Coordinates(x, y);
    }

    public AbsoluteHero(int x, int y) {
        this(String.format("Hero_Base #%d", ++AbsoluteHero.number), 
        AbsoluteHero.r.nextInt(100, 200), 
        AbsoluteHero.r.nextInt(500, 1000), 
        AbsoluteHero.r.nextInt(0, 50), x, y);
    }

    @Override
    public String getInfo() {
        return getClass().getName() + " " + name + " " + coordinates;
    }

    // Метод для поиска ближайшего противника
    public String findNearest (ArrayList<AbsoluteHero> enemyArmy){
        double minDistance = Coordinates.distance(coordinates.x, coordinates.y,
                            enemyArmy.get(0).coordinates.x, enemyArmy.get(0).coordinates.y);
        int j = 0;
        double dist = 0;
        for (int i = 1; i < enemyArmy.size(); i++) {
            dist = Coordinates.distance(coordinates.x, coordinates.y,
                    enemyArmy.get(i).coordinates.x, enemyArmy.get(i).coordinates.y);
            if (dist < minDistance) {
                minDistance = dist;
                j = i;
            }
        }
        return enemyArmy.get(j).getInfo() + "; distance: " + minDistance;
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
