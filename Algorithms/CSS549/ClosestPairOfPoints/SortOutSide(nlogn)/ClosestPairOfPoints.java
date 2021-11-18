import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yifei yang
 */
public class ClosestPairOfPoints {

    /**
     * used to remove the last output line break "\n"
     */
    public int maxIndex;

    /**
     * collect all points which both x and y coordinates are from the given txt file into one points array
     * @param fileName input points filename
     * @return points array
     */
    public  List<Point> initialData(String fileName) {
        BufferedReader br = null;
        List<Point> s = new ArrayList<>();
        try {
            br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(ClosestPairOfPoints.class.getResourceAsStream(fileName))));
            String line = br.readLine();
            maxIndex = Integer.parseInt(line) - 1;
            while ((line = br.readLine()) != null) {
                if (line.length() == 0) {
                    break;
                }

                // use regular expression to extract x and y coordinates
                String regex= "\\d+(?:\\.\\d+)?";
                Matcher m = Pattern.compile(regex).matcher(line);
                List<String> result= new ArrayList<>();
                while (m.find()){
                    result.add(m.group(0));
                }
                double x = Double.parseDouble(result.get(0));
                double y = Double.parseDouble(result.get(1));
                s.add(new Point(x, y));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return s;
    }

    /**
     * calculate the Euclidean Distance between two points
     * @param p1 first point
     * @param p2 second point
     * @return the Euclidean Distance between two points
     */
    public double Distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) *(p1.y - p2.y));
    }

    /**
     * format the output
     * @param x low index
     * @param y high index
     * @param distance  the current minimum Distance
     */
    public void printPoint(int x, int y, double distance) {
        if (x == 0 && y == this.maxIndex) {
            System.out.format("D[%d,%d]: %.4f", x, y, distance);
        } else {
            System.out.format("D[%d,%d]: %.4f\n", x, y, distance);
        }
    }

    public double calDirectly(List<Point> sx, int low, int high) {
        if (high - low == 1) {
            double currMinimumDistance = Distance(sx.get(low), sx.get(high));
            printPoint(low, high, currMinimumDistance);
            return currMinimumDistance;
        } else if (high - low == 2)	{
            double d1 = Distance(sx.get(low), sx.get(low + 1));
            double d2 = Distance(sx.get(low + 1), sx.get(high));
            double d3 = Distance(sx.get(low), sx.get(high));
            double d = Math.min(d1, Math.min(d2, d3));
            printPoint(low, high, d);
            return d;
        } else {
             return 0;
        }
    }

    /**
     * find the closest distance in the given range(low,high)
     * @param sx   points array sorted by x
     * @param sy   points array sorted by y
     * @param low  low index
     * @param high high index
     * @return  the closest distance in the given range(low,high)
     */
    public double Closest(List<Point> sx, List<Point> sy, int low, int high) {

        // If there are less than four points, then we calculate their closest distance directly
        if (high - low < 3) {
            return calDirectly(sx, low, high);
        }

        int mid = (low + high) / 2;
        Point middlePoint = sx.get(mid);


        List<Point> syLeft = new ArrayList<>();
        List<Point> syRight = new ArrayList<>();
        // put points which are sorted by y coordinate into each side
        for (Point point : sy) {
            if (point.x <= middlePoint.x) {
                syLeft.add(point);
            } else {
                syRight.add(point);
            }
        }

        // find the minimum distance of the left side
        double d1 = Closest(sx, syLeft, low, mid);
        // find the minimum distance of the right side
        double d2 = Closest(sx, syRight, mid + 1, high);
        double d = Math.min(d1, d2);

        // construct a middle-area points array to store points that are within the range[mid - d, mid + d]
        // add [mid - d, mid] points to array middleY
        List<Point> middleY = new ArrayList<>();
        for (Point p : sy) {
            if (p.x > middlePoint.x- d && p.x < middlePoint.x + d) {
                middleY.add(p);
            }
        }

        // find possible closest distance between two points (one if from left side, one is from right side)
        for (int i = 0; i < middleY.size(); i++) {
            for (int j = 1; j < 7 && i + j < middleY.size(); j++)	{
                d = Math.min(d, Distance(middleY.get(i), middleY.get(i + j)));
            }
        }
        printPoint(low, high, d);
        return d;
    }

    public static void main(String[] args) {
        ClosestPairOfPoints closestPairOfPoints = new ClosestPairOfPoints();

        // get points array sx and xy
        List<Point> sx = closestPairOfPoints.initialData("program2data.txt");
        List<Point> sy = new ArrayList<>(sx);

        // sort all points by its x coordinate
        sx.sort(new ComparatorX());
        sy.sort(new ComparatorY());

        // find the closest pair distance
        closestPairOfPoints.Closest(sx, sy, 0, sx.size() - 1);
    }
}


