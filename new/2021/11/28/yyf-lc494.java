class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum < Math.abs(target)) {
            return 0;
        }
        int[][] dp = new int[n+1][2 * totalSum + 1];
        int offset = totalSum;
        dp[0][offset] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = nums[i]; j < 2 * totalSum + 1 - nums[i]; j++) {
                if (dp[i][j] > 0) {
                    dp[i+1][j + nums[i]] += dp[i][j];
                    dp[i+1][j - nums[i]] += dp[i][j];
                }
            }
        }
        for (int d[] : dp) {
            System.out.println(Arrays.toString(d));
        }
        return dp[n][target + offset];
        
    }
}
