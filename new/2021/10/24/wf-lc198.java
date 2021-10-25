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
