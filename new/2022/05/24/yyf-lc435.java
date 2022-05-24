// T:O(NlogN)
// S:O(1)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0;
        int end = Integer.MIN_VALUE;
        for (int[] cur : intervals) {
            if (cur[0] >= end) {
                end = cur[1];
            } else {
                count++;
            }
        }
        return count;
    }
}
