/*
O(nlogn) Solution, Greedy
对end进行排序, 如果之前没有元素被选择过，那么一定选择最后两个元素， 一个元素被选择了，选取当前区间的最后一个元素
*/
public class Solution {
	public int intersectionSizeTwo(int[][] intervals) {
        
		Arrays.sort(intervals, (interval1, interval2) -> (interval1[1] - interval2[1]));
		int max1 = -1;
        int max2 = -1;
        int ans = 0;
        
        /*
(1) If there is no number in this interval being chosen before, we pick up 2 biggest number in this interval. (the biggest number have the most possibility to be used by next interval)
(2) If there is one number in this interval being chosen before, we pick up the biggest number in this interval.
(3) If there are already two numbers in this interval being chosen before, we can skip this interval since the requirement has been fulfilled.
        */
        
		for (int[] interval : intervals) {
			int start = interval[0];
            int end = interval[1];
			if (start > max1) {
				ans += 2;
				max2 = end - 1;
				max1 = end;
			} else if (start > max2) {
				ans += 1;
				max2 = max1 == end ? max1 - 1 : max1;
				max1 = end;
			}
		}
		return ans;
	}
}
