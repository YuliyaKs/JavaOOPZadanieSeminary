package units;

public class Coordinates {
    int x;
    int y;

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
    public static int[] getCoordinates(AbsoluteHero hero){
        int[] coordinates = new int[2];
        coordinates[0] = hero.coordinates.x;
        coordinates[1] = hero.coordinates.y;
        return coordinates;
    }
}