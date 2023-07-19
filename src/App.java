import units.*;
import units.Coordinates;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class App {
    public static void main(String[] args) {

        ArrayList<AbsoluteHero> armyLightForces = new ArrayList<>();
        fillArmyLF(armyLightForces);
//        for (AbsoluteHero absoluteHero : armyLightForces) {
//            System.out.println(absoluteHero.getInfo());
//        }

        System.out.println();
        
        ArrayList<AbsoluteHero> armyDarkForces = new ArrayList<>();
        fillArmyDF(armyDarkForces);
//        for (AbsoluteHero absoluteHero : armyDarkForces) {
//            System.out.println(absoluteHero.getInfo());
//        }

//        System.out.println();
//
//        for(AbsoluteHero hero: armyLightForces){
//            System.out.println(hero.getInfo() + " - " +
//                    hero.findNearest(armyDarkForces).getInfo() + "; distance: " +
//                    Coordinates.distance(Coordinates.getCoordinates(hero)[0], Coordinates.getCoordinates(hero)[1],
//                            hero.findNearest(armyDarkForces)));
//        }
//
//        System.out.println();
//
//        for(AbsoluteHero hero: armyDarkForces){
//            System.out.println(hero.getInfo() + " - " +
//                    hero.findNearest(armyLightForces).getInfo() + "; distance: " +
//                    Coordinates.distance(Coordinates.getCoordinates(hero)[0], Coordinates.getCoordinates(hero)[1],
//                            hero.findNearest(armyLightForces)));
//        }
//
//        System.out.println();

//        Вызывать персонажей из обеих комманд в порядке инициативы.
        ArrayList<AbsoluteHero> army = new ArrayList<>();
        army.addAll(armyLightForces);
        army.addAll(armyDarkForces);
        army.sort(Comparator.comparing((AbsoluteHero hero) -> hero.initiative));

        armyLightForces.forEach(n -> System.out.println(n.getInfo()));
        armyDarkForces.forEach(n -> System.out.println(n.getInfo()));
        System.out.println("---------------");
        for (int i = 19; i > 0; i-- ){
            if (armyLightForces.contains(army.get(i))) {
                army.get(i).step(armyDarkForces, armyLightForces);
                System.out.println(army.get(i).getInfo() +  " " + army.get(i).initiative);
            }else {
                army.get(i).step(armyLightForces, armyDarkForces);
                System.out.println(army.get(i).getInfo() +  " " + army.get(i).initiative);
            }

        }
        System.out.println("---------------");
        armyLightForces.forEach(n -> System.out.println(n.getInfo()));
        armyDarkForces.forEach(n -> System.out.println(n.getInfo()));

    }
    public static void fillArmyLF (ArrayList<AbsoluteHero> ArrList) {
        for (int i = 1; i < 11; i++) {
            int count = new Random().nextInt(0, 4);
            switch (count) {
                case 0: {
                    ArrList.add(new Countryman(1, i, 3));
                    break;                    
                }
                case 1: {
                    ArrList.add(new Arbalester(1, i, 9));
                    break;                    
                }
                case 2: {
                    ArrList.add(new Monastic(1, i, 5));
                    break;
                }
                case 3: {
                    ArrList.add(new Pikeman(1, i, 7));
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
                    ArrList.add(new Countryman(10, i, 3));
                    break;                    
                }
                case 1: {
                    ArrList.add(new Bandit(10, i, 8));
                    break;                    
                }
                case 2: {
                    ArrList.add(new Killer(10, i, 10));
                    break;
                }
                case 3: {
                    ArrList.add(new Mage(10, i, 6));
                    break;
                }

            }               
        }
    }
}

