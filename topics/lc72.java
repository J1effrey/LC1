class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i-1][j-1],   // replace
                                        Math.min(dp[i-1][j] + 1, // delete
                                       dp[i][j-1] + 1) // insert
                                       ); 
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1, // replace
                                        Math.min(dp[i-1][j] + 1, // delete
                                       dp[i][j-1] + 1) // insert
                                       );
                }
            }
        }
        return dp[m][n];
    }
}