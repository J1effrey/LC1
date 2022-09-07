class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            
            dq.offer(i);
            if (i >= k - 1) {
                res[index++] = nums[dq.peek()];
            }
        }
        
        return res;
    }
}

-----------------------------------------------------------
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[N - k + 1];
        for (int i = 0; i < N; i++) {
            int startWindowIndex = i - k + 1;
            while (!q.isEmpty() && i - q.peekFirst() >= k) q.pollFirst(); // 左出q,保证窗口大小k - 1
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.pollLast(); // 右出q，保证递减队列
            q.offerLast(i);  // 进q，此时q.size == k
            if (startWindowIndex >= 0) res[startWindowIndex] = nums[q.peekFirst()]; // 使用q左边最大值
        }
        return res;
    }
}
