package com.yyf.css549.problem2;

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
    public List<Point> initialData(String fileName) {
        BufferedReader br = null;
        List<Point> S = new ArrayList<>();
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
                S.add(new Point(x, y));
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
        return S;
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

    /**
     * find the current minimum distance between some two points within the give range [low, high]
     * @param S all points
     * @param low low index
     * @param high high index
     * @return the current closest distance
     */
    public double Closest(List<Point> S, int low, int high) {
        double d1, d2, d3, d;

        // If there are only two points, then we return their distance directly
        if (high - low == 1) {
            double currMinimumDistance = Distance(S.get(low), S.get(high));
            printPoint(low, high, currMinimumDistance);
            return currMinimumDistance;
        }

        // If there are three points, then we calculate each pair of points and return the minimum distance
        if (high - low == 2)	{
            d1 = Distance(S.get(low), S.get(low + 1));
            d2 = Distance(S.get(low + 1), S.get(high));
            d3 = Distance(S.get(low), S.get(high));
            d = Math.min(d1, Math.min(d2, d3));
            printPoint(low, high, d);
            return d;
        }

        int mid = (low + high) / 2;				// the middle point's index
        d1 = Closest(S, low, mid);			// find the minimum distance of the left side
        d2 = Closest(S, mid + 1, high);		// find the minimum distance of the right side
        d = Math.min(d1, d2);

        // construct a middle-area points array to store points that are within the range[mid - d, mid + d]
        List<Point> P = new ArrayList<>();

        // add [mid - d, mid] points to array P
        for (int i = mid; (i >= low) && (S.get(mid).x - S.get(i).x < d); i--) {
            P.add(S.get(i));
        }

        // add [mid, mid + p] points to array P
        for (int i = mid + 1; (i <= high) && (S.get(i).x - S.get(mid).x < d); i++) {
            P.add(S.get(i));
        }

        // sort points in P by its vertical coordinate
        P.sort(new ComparatorY());

        //  calculate all possible distance of two points within the middle area(one is from left, another is from right)
        for (int i = 0; i < P.size(); i++) {
            for (int j = 1; j < 7 && i + j < P.size(); j++)	{
                d = Math.min(d, Distance(P.get(i), P.get(i + j)));
            }
        }

        printPoint(low, high, d);
        return d;
    }

    public static void main(String[] args) {
        ClosestPairOfPoints cpop = new ClosestPairOfPoints();
        // get points array
        List<Point> s = cpop.initialData("program2data100.txt");

        // sort all points by its x coordinate
        Collections.sort(s);

        // find the closest pair distance
        cpop.Closest(s, 0, s.size() - 1);
    }
}


