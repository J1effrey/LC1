// T: O(n)
// S: O(1)
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prePre = 0;
        int pre = nums[0];
        int curMax = nums[0];
        
        
        for (int i = 2; i <= nums.length; i++) {
            curMax = Math.max(prePre + nums[i - 1], pre);
            prePre = pre;
            pre = curMax;
        }
        return curMax;
    }
}



// T: O(n)
// S: O(n)
class Solution {
    /*
    dp[i]: Max mon from 0 - i
    dp[i]:Math.max(dp[i - 1], d[i - 2] + A[i - 1])
    */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] res = new int[nums.length + 1];
        res[0] = 0;
        res[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i - 1]);
        }
        
        return res[nums.length];
    }
}
