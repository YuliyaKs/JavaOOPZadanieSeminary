package units.helpers;

import units.abstractclass.AbsoluteHero;

public class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static double distance (int x, int y, AbsoluteHero hero2){
        return Math.sqrt(Math.pow(x - hero2.coordinates.x, 2) +
                Math.pow(y - hero2.coordinates.y, 2));
    }

    @Override
    public String toString() {
        return "(x: " + x + "; y: " + y +")";
    }

}