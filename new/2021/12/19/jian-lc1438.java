// Time: O(N)
// Space: O(N)
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int res = 1;

        int l = 0;

        // find the longest subarray for every right pointer by shrinking left pointer
        for (int r = 0; r < nums.length; ++r) {

            // update maxDeque with new right pointer
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[r]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(nums[r]);

            // update minDeque with new right pointer
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[r]) {
                minDeque.removeLast();
            }
            minDeque.addLast(nums[r]);

            // shrink left pointer if exceed limit
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[l]) maxDeque.pollFirst();
                if (minDeque.peekFirst() == nums[l]) minDeque.pollFirst();
                ++l;  // shrink it!
            }

            // update res
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}

---------------------------------------------------------------------
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!maxd.isEmpty() && maxd.peekLast() < nums[i]) maxd.pollLast();
            while (!mind.isEmpty() && nums[i] < mind.peekLast()) mind.pollLast();
            maxd.add(nums[i]);
            mind.add(nums[i]);
            // if!!!!!!!!!!!!!
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == nums[left]) maxd.poll();
                if (mind.peek() == nums[left]) mind.poll();
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
