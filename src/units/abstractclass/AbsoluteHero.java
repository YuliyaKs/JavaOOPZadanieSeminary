package units.abstractclass;
import java.util.ArrayList;
import java.util.Random;

import units.helpers.AppInterface;
import units.helpers.Coordinates;
import units.helpers.Names;
import units.helpers.States;

// Класс Базовый Герой
public abstract class AbsoluteHero implements AppInterface {

    protected static int number;
    protected static Random r;

    protected String name;
    protected int hp; // жизненная сила
    protected int maxHp;
    protected int[] damage;

    public int initiative;
    public Coordinates coordinates;

    public States state;

    static {
        AbsoluteHero.number = 0;
        AbsoluteHero.r = new Random();
    }

    public AbsoluteHero(String name, int hp, int[] damage, int x, int y, int initiative, States state) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.damage = damage;
        this.coordinates = new Coordinates(x, y);
        this.initiative = initiative;
        this.state = state;
     }

    public AbsoluteHero(int[] damage, int x, int y, int initiative, States state) {
        this(AbsoluteHero.getName(),
                AbsoluteHero.r.nextInt(100, 200),
                damage, x, y, initiative, state);
    }

    // Метод получения имени
    public static String getName(){
        String name = String.valueOf(Names.values()[AbsoluteHero.r.nextInt(Names.values().length)]
                + " #" + ++AbsoluteHero.number);
        return name;
    }

    public int getHp() {return hp;}

    public int[] getCoords() {
        int[] coord = new int[] {coordinates.x, coordinates.y};
        return coord;
    }

    @Override
    public String getInfo() {
        return getClass().getName().substring(6)
                + " " + name + " \u2661:" + hp + " \u2299:" + coordinates + " \u2655:" + initiative + " \u2605:" + state;
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

    // Метод атаки
    public void attack(AbsoluteHero target, int damage) {
        target.GetDamage(damage);
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
        this.state = States.Die;
        return;
    }

    // Метод лечение
    public void healing(AbsoluteHero target, int damage) {
        target.hp -= damage;
        if (target.hp > target.maxHp) target.hp = maxHp;
    }
}
