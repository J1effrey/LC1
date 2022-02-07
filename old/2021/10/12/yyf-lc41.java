class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }
        
        for (int i = 0; i < length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index >= 0 && index < length) {
                if (nums[index] > 0) {
                    nums[index] = -nums[index];
                } else if (nums[index] == 0) {
                    nums[index] = - (length + 1);
                }
            }
        }
        
        for (int i = 0; i < length; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        
        return length + 1;
    }
}
