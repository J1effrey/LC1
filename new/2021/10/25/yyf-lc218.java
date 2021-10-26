class Solution {
    private class Point implements Comparable<Point>{
        private int x;
        private int height;
        private boolean isStart;
        
        public Point(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }

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
                return this.isStart? -1 : 1;
            }
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        int len = buildings.length;

        if (buildings == null || len == 0 || buildings[0].length == 0) {
            return res;
        }
        
        Point[] points = new Point[len * 2];
        int index = 0;

        for (int[] building : buildings) {
            int start = building[0];
            int end = building[1];
            int h = building[2];
            points[index++] = new Point(start, h, true);
            points[index++] = new Point(end, h, false);
            
        }
        
        Arrays.sort(points);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.offer(0);
        
        int prevMaxVal = queue.peek();
        for (Point point : points) {
            if (point.isStart) {
                queue.offer(point.height);
                if (queue.peek() > prevMaxVal) {
                    res.add(getOutputPoint(point.x, point.height));
                    prevMaxVal = queue.peek();
                }
            } else {
                queue.remove(point.height);
                if (queue.peek() < prevMaxVal) {
                    res.add(getOutputPoint(point.x, queue.peek()));
                    prevMaxVal = queue.peek();
                }
                
            }
        }
        return res;
    }
    
    private List<Integer> getOutputPoint(int x, int y) {
        List<Integer> outputPoint = new ArrayList<Integer>();
        outputPoint.add(x);
        outputPoint.add(y);
        
        return outputPoint;
    }

}

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
