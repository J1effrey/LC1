class Solution {
    // 单调队列O(n)
    public int maxResult(int[] nums, int k) {
        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = nums[0];
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(0);
        for (int i = 1; i < N; i++) {
            dp[i] = dp[q.peekFirst()] + nums[i];
            while (!q.isEmpty() && i - q.peekFirst() >= k) q.pollFirst();
            while (!q.isEmpty() && dp[q.peekLast()] <= dp[i]) q.pollLast();
            q.offerLast(i);
        }
        return dp[N - 1];
    }
}
