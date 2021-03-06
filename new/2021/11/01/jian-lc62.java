// T: O(m * n)
// S: O(m * n)

class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        
        int[][] dp = new int[m][n];
        
        for (int[] row: dp) {
            Arrays.fill(row, 1);
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
