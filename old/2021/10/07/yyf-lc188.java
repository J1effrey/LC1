/*
dp[i][j]: maxProfit before day j with i transaction
dp[i][j] = dp[i][j - 1] / dp[i - 1][m] + (prices[j] - prices[m])  m : 0 to j - 1;

i = 2  j = 5 
*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[k+1][prices.length];
        for (int i = 1; i < k + 1; i++) {
            int diff = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + diff);
                diff = Math.max(diff, dp[i - 1][j] - prices[j]);
            }
        }
        
        return dp[k][prices.length - 1];
    }
}