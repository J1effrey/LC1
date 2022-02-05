// T: O(M + N)
// S: O(M + N)
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0) {
            return new int[][]{};
        }
        
        int p1 = 0;
        int p2 = 0;
        List<int[]> res = new ArrayList<int[]>();
        
        while (p1 < firstList.length && p2 < secondList.length) {
            int[] first = firstList[p1];
            int[] second = secondList[p2];
            
            int start = Math.max(first[0], second[0]);
            int end = Math.min(first[1], second[1]);
            
            if (start <= end) {
                res.add(new int[]{start, end});
            }
            
            if (first[1] > second[1]) {
                p2++;
                continue;
            }
            p1++;
        }
            
        int[][] array = new int[res.size()][2];
        return res.toArray(array); 
    }
}
