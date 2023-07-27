package units.helpers;

import units.abstractclass.AbsoluteHero;

public class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
    public double distance(AbsoluteHero hero2){
        return Math.sqrt(Math.pow(this.x - hero2.coordinates.x, 2) +
                Math.pow(this.y - hero2.coordinates.y, 2));
    }

    public int[] stepCoord(Coordinates coordEnemy) {
        int[] stepCoord = {x, y};
        if (Math.abs(this.x - coordEnemy.x) > Math.abs(this.y - coordEnemy.y)){
            if (coordEnemy.x > this.x) stepCoord[0] += 1;
            else stepCoord[0] -= 1;
        }
        else {
            if (coordEnemy.y > this.y) stepCoord[1] += 1;
            else stepCoord[1] -= 1;
        }
        return stepCoord;
    }

    @Override
    public String toString() {
        return "(x: " + x + "; y: " + y +")";
    }

}
