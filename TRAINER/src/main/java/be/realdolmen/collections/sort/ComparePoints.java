package be.realdolmen.collections.sort;

import java.util.Comparator;

public class ComparePoints implements Comparator<Point> {
    @Override
    public int compare(Point y1, Point y2) {
        return y1.compareTo(y2);
    }
}
