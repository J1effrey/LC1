class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] curr = intervals[0];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (canMerge(curr, intervals[i])) {
                curr = merge(curr, intervals[i]);
            } else {
                res.add(curr);
                curr = intervals[i];
            }
        }
        res.add(curr);
        return res.toArray(new int[res.size()][]);
    }
    
    public boolean canMerge(int[] x, int[] y) {
        return x[1] >= y[0];
    }
    
    public int[] merge(int[] x, int[] y) {
        return new int[]{Math.min(x[0], y[0]), Math.max(x[1], y[1])};
    }
}

/===================================================================/
 class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][0];
        }
        int n = intervals.length;
        int[][] res = new int[n][2];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        res[0] = intervals[0];
        int index = 0;
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            if (interval[0] > res[index][1]) {
                res[++index] = interval;
            } else {
                res[index][1] = Math.max(interval[1], res[index][1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
        
    }
}
