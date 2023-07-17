import units.*;

import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) {

        ArrayList<AbsoluteHero> armyLightForces = new ArrayList<>();
        fillArmyLF(armyLightForces);
        for (AbsoluteHero absoluteHero : armyLightForces) {
            System.out.println(absoluteHero.getInfo());
        }

        System.out.println();
        
        ArrayList<AbsoluteHero> armyDarkForces = new ArrayList<>();
        fillArmyDF(armyDarkForces);
        for (AbsoluteHero absoluteHero : armyDarkForces) {
            System.out.println(absoluteHero.getInfo());
        }

        System.out.println();

        for(AbsoluteHero hero: armyLightForces){
            System.out.println(hero.getInfo() + " - " + hero.findNearest(armyDarkForces));
        }

        System.out.println();

        for(AbsoluteHero hero: armyDarkForces){
            System.out.println(hero.getInfo() + " - " + hero.findNearest(armyLightForces));
        }

    }
    public static void fillArmyLF (ArrayList<AbsoluteHero> ArrList) {
        for (int i = 1; i < 11; i++) {
            int count = new Random().nextInt(0, 4);
            switch (count) {
                case 0: {
                    ArrList.add(new Countryman(1, i));
                    break;                    
                }
                case 1: {
                    ArrList.add(new Arbalester(1, i));
                    break;                    
                }
                case 2: {
                    ArrList.add(new Monastic(1, i));
                    break;
                }
                case 3: {
                    ArrList.add(new Pikeman(1, i));
                    break;
                }

            }               
        }
    }

    public static void fillArmyDF (ArrayList<AbsoluteHero> ArrList) {
        for (int i = 1; i < 11; i++) {
            int count = new Random().nextInt(0, 4);
            switch (count) {
                case 0: {
                    ArrList.add(new Countryman(10, i));
                    break;                    
                }
                case 1: {
                    ArrList.add(new Bandit(10, i));
                    break;                    
                }
                case 2: {
                    ArrList.add(new Killer(10, i));
                    break;
                }
                case 3: {
                    ArrList.add(new Mage(10, i));
                    break;
                }

            }               
        }
    }
}

