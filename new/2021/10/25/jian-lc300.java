class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] tails = new int[nums.length]; // dp[i] / tails[i] : the smallest ending number of sub-sequence [0, i], i included 
        tails[0] = nums[0];
        int size = 1;
        
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int start = 0;
            int end = size - 1;
            
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (tails[mid] <= cur) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            
            if (cur > tails[end]) {
                tails[end + 1] = cur;
                size++;
            } else if (cur > tails[start] && cur <= tails[end]) {
                tails[end] = cur;
            } else {
                tails[start] = cur;
            }
        }
        
        return size;
    }
}
