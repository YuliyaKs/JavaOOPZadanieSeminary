package units.abstractclass;

import units.Countryman;
import units.helpers.States;

import java.util.ArrayList;

// Абстрактный класс Жрецы
public abstract class Psychic extends AbsoluteHero {
    
    public int mana;  // магия
    public int maxMana;

    public Psychic(int[] damage, int x, int y, int initiative, States state) {
        super(getName(), Psychic.r.nextInt(100, 200), damage, x, y, initiative, state);
        this.maxMana = Psychic.r.nextInt(50, 150);
        this.mana = maxMana;
    }

    // Метод ход
    @Override
    public void step(ArrayList<AbsoluteHero> enemyArmy, ArrayList<AbsoluteHero> ownArmy) {
        int index = 0;
        int sick = ownArmy.get(index).hp * 100 / ownArmy.get(index).maxHp;
        for (int i = 1; i < ownArmy.size(); i++) {
            if(ownArmy.get(i).hp * 100 / ownArmy.get(i).maxHp < sick) {
                index = i;
            }
        }
        this.healing(ownArmy.get(index), damage[0]);
    }

    @Override
    public String getInfo() {
        return getClass().getName().substring(6)
                + " " + name + " \u2661:" + hp + " \u2299:" + coordinates + " \u2655:" + initiative + " \u2605:" + state;
    }
}
