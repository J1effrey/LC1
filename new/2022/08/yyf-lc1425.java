class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] sum = new int[nums.length];   // sum[i] means local max sum till i
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum[i] = nums[i];
            if (!q.isEmpty()) sum[i] += sum[q.peekFirst()];
            res = Math.max(res, sum[i]);
            if (!q.isEmpty() && i - q.peek() >= k) q.pollFirst();
            while (!q.isEmpty() && sum[q.peekLast()] <= sum[i]) q.pollLast();
            if (sum[i] > 0) q.offerLast(i);
        }
        return res;
    }
}
