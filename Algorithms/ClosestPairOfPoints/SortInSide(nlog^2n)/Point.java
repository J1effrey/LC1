/**
 * use Class Point to store x(horizontal) and y(vertical) coordinate.
 */
public class Point implements Comparable<Point>{
        double x;
        double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

    // used sort points array
    @Override
    public int compareTo(Point o) {
        if (this.x > o.x) {
            return 1;
        } else if (this.x < o.x) {
            return -1;
        } else {
            // when the points have the same x coordinate, we sort them by its y coordinate
            return new ComparatorY().compare(this, o);
        }
    }
}
