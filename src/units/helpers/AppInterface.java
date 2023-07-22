package units.helpers;

import units.abstractclass.AbsoluteHero;

import java.util.ArrayList;

public interface AppInterface {

    void step(ArrayList<AbsoluteHero> enemyArmy, ArrayList<AbsoluteHero> ownArmy);
    
    String getInfo();

}
