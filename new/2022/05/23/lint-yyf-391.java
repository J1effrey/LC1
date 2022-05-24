// T:O(NlogN)
// S:O(N)
public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
     class Point {
         int T;
         int S;
         Point(int T, int S) {
             this.T = T;
             this.S = S;
         }
     }
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        List<Point> list = new ArrayList<>(airplanes.size() * 2);
        for (Interval i : airplanes) {
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, -1));
        }

        Collections.sort(list, (Point p1, Point p2) -> {
            if (p1.T == p2.T) return p1.S - p2.S;
            return p1.T - p2.T;
        });

        int count = 0;
        int res = 0;
        for (Point p : list) {
            count += p.S;
            res = Math.max(res, count);
        }
        return res;
    }
}
