// Time:  O(amount * num-coins)
// Space: o(amount), We use extra space for the memoization table.

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }   
            }
        }
        
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}

---------------------
    
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        
        if (amount <= 0) {
            return 0;
        }
        
        
        int level = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(amount);
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(amount);
        
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int coin: coins) {
                    if (cur == coin) {
                        return level;
                    } else {
                        int remain = cur - coin;
                        if (remain > 0 && !visited.contains(remain)) {
                            q.offer(remain);
                            visited.add(remain);
                        }
                    }     
                }
            }
        }   
        
        return -1;
    }
}
