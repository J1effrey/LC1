class Solution {
    public int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length == 0) {
            return 0;    
        }
        
        // maxDeque and minDeque are used to store the max and min value in this particular subarray
        // Array[l , r]
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int res = 1;
        int l = 0;

        // find the longest subarray for every right pointer by shrinking left pointer
        for (int r = 0; r < nums.length; r++) {

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
                if (maxDeque.peekFirst() == nums[l]) {
                    maxDeque.pollFirst();
                }
                
                if (minDeque.peekFirst() == nums[l]) {
                    minDeque.pollFirst();
                }
                l++;  // shrink it!
            }

            // update res
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
