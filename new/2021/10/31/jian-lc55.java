class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        
        int maxLevel = nums[0];
        for (int i = 1; i <= maxLevel; i++) {
            if (maxLevel >= nums.length - 1) {
                return true;
            }
            maxLevel = Math.max(maxLevel, i + nums[i]);
        }
        
        return false;
    }
}
