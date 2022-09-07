class Solution {
    /*
    求出前缀和之后，需求：j > i && preSum[j] - preSum[i] >= k && (j - i) 最小
    
    双端递增队列：对于当前的“我”来说，如果前面的人比我高，那么我的身高-这些比我高点的人的身高一定是负数，因此直接弹出
    对于队列中剩余都是比我矮的人，如果第一个矮个子和我的差距比k小，那么后面的和我的差距肯定小于k。
    为什么要弹出呢？因为前面几个和我相比比我矮k的，哪怕后面还有比我高的，这些矮个子和我后面的高个子的距离都比我和这些矮个子距离远。也就是子数组的长度更大
    */
    public int shortestSubarray(int[] nums, int k) {
        int N = nums.length;
        int res = N + 1;
        long[] sum = new long[N + 1];
        for (int i = 0; i < N; i++) sum[i + 1] = sum[i] + nums[i];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            while (!q.isEmpty() && sum[i] - sum[q.peekFirst()] >= k)  res = Math.min(res, i - q.pollFirst());
            while (!q.isEmpty() && sum[q.peekLast()] >= sum[i])       q.pollLast();
            q.offerLast(i);
        }
        return res <= N ? res : -1;
    }
}
