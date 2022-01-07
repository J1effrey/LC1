// T: O(N * N)
// S: O(N)

class Solution {
    /*
    if a point should go to the result?
     -> if the point changes the current max height
    
    1. maintain cur max height : PriorityQueue, maxHeap, reverseOrder
    
        differentiate start and end point, 
        if I meet end point, should have the start point left, and if start point changes max height, I will need to change max height.
    
    2. find the breakers that changes max height
    */
    class Point implements Comparable<Point> {
        int x;
        int height;
        boolean isStart;
        
        public Point(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
        
        @Override
        public int compareTo(Point p) {
            if (this.x != p.x) {
                return this.x - p.x;
            } else {
                if (this.isStart && p.isStart) {
                    return p.height - this.height;
                }
                if (!this.isStart && !p.isStart) {
                    return this.height - p.height;
                }
                return this.isStart ? -1 : 1;
            }
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (buildings == null || buildings.length == 0 || buildings[0] == null || buildings[0].length == 0) {
            return res;
        }
        
        Point[] points = new Point[2 * buildings.length];
        int index = 0;
        for (int[] building : buildings) {
            int start = building[0];
            int end = building[1];
            int height = building[2];
            points[index++] = new Point(start, height, true);
            points[index++] = new Point(end, height, false);
        }
        
        Arrays.sort(points);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        queue.offer(0);
        
        int preMaxVal = queue.peek();
        for (Point point: points) { // O(n)
            if (point.isStart) {
                queue.offer(point.height);
                if (queue.peek() > preMaxVal) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(point.x);
                    list.add(queue.peek());
                    res.add(list);
                    preMaxVal = queue.peek();
                }
            } else {
                queue.remove(point.height); // O(n)
                if (queue.peek() < preMaxVal) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(point.x);
                    list.add(queue.peek());
                    res.add(list);
                    preMaxVal = queue.peek();
                }
            }
        }
        
        return res;
    }
}


// T: O(N * logN)
// S: O(N)
/*
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> skyLine = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return skyLine;
        }
        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        // [2,3] [2,5]
        Collections.sort(heights, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        treeMap.put(0, 1);
        int prevMax = 0;
        for (int[] h : heights) {
            if (h[1] < 0) {
                Integer cnt = treeMap.get(-h[1]);
                cnt = cnt == null ? 1 : cnt + 1;
                treeMap.put(-h[1], cnt);
            } else {
                Integer cnt = treeMap.get(h[1]);
                if (cnt == 1) {
                    treeMap.remove(h[1]);
                } else {
                    treeMap.put(h[1], cnt - 1);
                }
            }
            int currMax = treeMap.firstKey();
            if (currMax != prevMax) {
                List<Integer> temp = new ArrayList<>();
                temp.add(h[0]);
                temp.add(currMax);
                skyLine.add(temp);
                prevMax = currMax;
            }
        }
        
        return skyLine;
    }
}
*/
