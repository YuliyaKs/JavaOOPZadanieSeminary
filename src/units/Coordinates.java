package units;

public class Coordinates {
    int x;
    int y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static double distance (int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    @Override
    public String toString() {
        return "(x: " + x + "; y: " + y +")";
    }
}
