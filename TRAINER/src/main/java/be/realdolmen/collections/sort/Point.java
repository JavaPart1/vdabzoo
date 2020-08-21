package be.realdolmen.collections.sort;

public class Point implements Comparable<Point>  {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


    @Override
    public int compareTo(Point o) {
        int val = Integer.compare(getX(), o.getX());
        if (val != 0) {
            return val;
        }
        return Integer.compare(getY(), o.getY());
    }
}
