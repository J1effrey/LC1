class Solution {
    public int countPrimes(int n) {
        boolean[] dp = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (dp[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    dp[i * j] = true;
                }
            }
        }
        
        return count;
    }
}

/*
dp[]
10
2 4 6 8
3 6 9
5 
7
2 3 5 7
*/
