// T:O(N)
// S:O(1)
class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] interval : intervals) {
            // no overlap
            if (interval[1] < toBeRemoved[0] || interval[0] > toBeRemoved[1]) {
                res.add(Arrays.asList(interval[0], interval[1]));
                continue;
            } 
            // has overlap
            // left and extra
            if (interval[0] < toBeRemoved[0]) {
                res.add(Arrays.asList(interval[0], toBeRemoved[0]));
            } 
            // right and extra
            if (interval[1] > toBeRemoved[1]) {
                res.add(Arrays.asList(toBeRemoved[1], interval[1]));
            }
            
        }
        return res;
    }
}
