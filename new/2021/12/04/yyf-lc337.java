class Solution {
    public int combinationSum4(int[] candidates, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int candidate : candidates) {
                if (i - candidate >= 0)
                dp[i] += dp[i - candidate];
            }
        }
        return dp[target];
    }
}

/*
dp[0] = 1
dp[1] = 1
dp[2] = dp[1] + dp[0] = 2;
dp[3] = dp[0] + dp[1] + dp[2] = 4
dp[4] = dp[1] + d[2] + dp[3] = 7
*/