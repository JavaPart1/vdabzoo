package be.realdolmen.collections.sort;

import java.util.Arrays;

public class SortingPoints {
    public static void main(String[] args) {
        new SortingPoints().start();

    }

    private void start() {
        Point[] points = new Point[100];
        for (int i = 0; i < 100; i++) {
            points[i] = new Point((int) (Math.random() * 50), (int) (Math.random() * 50));
        }
        Arrays.sort(points, new ComparePoints());
        for(Point i : points){
            System.out.println(i);
        }
    }
}
