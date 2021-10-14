class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int fast = 0;
        int slow = 0;
        
        while (fast < nums.length && nums[fast] < nums.length) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (fast == slow) {
                fast = 0;
                while (fast != slow) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                
                return slow;
            }
        }
        
        return 0;
    }
}
