import java.util.Comparator;

/**
 * Comparator is used to sort points by its X(horizontal) coordinate
 * @author yifei yang
 */
public class ComparatorX implements Comparator<Point> {

    @Override
    public int compare(Point p1, Point p2) {
        if (p1.x > p2.x) {
            return 1;
        } else if (p1.x < p2.x) {
            return -1;
        } else {
            return 0;
        }
    }
}
