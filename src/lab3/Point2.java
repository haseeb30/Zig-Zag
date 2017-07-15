package lab3;

/**
 * A simple class for representing points in 2D Cartesian coordinates. Every
 * Point2D instance has an x and y coordinate.
 * 
 * @author EECS2030 Fall 2016
 *
 */
public class Point2 {

    private double x;
    private double y;

    public Point2() {

    }

    public Point2(Double newX, Double newY) {
        x = newX;
        y = newY;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void set(Double newX, Double newY) {
        x = newX;
        y = newY;
    }

    public void setX(Double newX) {
        x = newX;

    }

    public void setY(Double newY) {

        y = newY;
    }

    public String toString() {
        String str = "(" + x + ", " + y + ")";
        return str;
    }

}