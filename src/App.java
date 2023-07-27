import units.*;
import units.abstractclass.AbsoluteHero;
import units.helpers.States;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static ArrayList<AbsoluteHero> armyLightForces = new ArrayList<>();
    public static ArrayList<AbsoluteHero> armyDarkForces = new ArrayList<>();

    public static ArrayList<AbsoluteHero> army = new ArrayList<>();
    public static void main(String[] args) {

        fillArmyLF(armyLightForces);

        fillArmyDF(armyDarkForces);

//        Вызывать персонажей из обеих комманд в порядке инициативы.
        army.addAll(armyLightForces);
        army.addAll(armyDarkForces);
        army.sort(Comparator.comparing((AbsoluteHero hero) -> hero.initiative));

        Scanner in = new Scanner(System.in);

        while (true) {
            for (int i = 19; i >= 0; i--) {
                if (armyLightForces.contains(army.get(i))) {
                    army.get(i).step(armyDarkForces, armyLightForces);
                } else {
                    army.get(i).step(armyLightForces, armyDarkForces);
                }

            }
            View.view();
            in.nextLine();
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
                    ArrList.add(new Wizard(10, i));
                    break;
                }

            }               
        }
    }
}

