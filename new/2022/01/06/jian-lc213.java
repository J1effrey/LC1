// T: O(n)
// S: O(1)

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        return Math.max(
            robHelper(nums, 0, nums.length - 2), 
            robHelper(nums, 1, nums.length - 1));
    }
    
    public int robHelper(int[] nums, int start, int end) {   
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int prePre = 0;
        int pre = nums[start];
        int curMax = nums[start];
        
        
        for (int i = start + 1; i <= end; i++) {
            curMax = Math.max(prePre + nums[i], pre);
            prePre = pre;
            pre = curMax;
        }
        
        return curMax;
    }
}
