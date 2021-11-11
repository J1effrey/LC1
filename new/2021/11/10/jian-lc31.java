class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int breakerIndex = findBreakerIndex(nums);
        if (breakerIndex != -1) {
            int rightMostBigger = findRightMostBigger(nums, nums[breakerIndex], breakerIndex);
            if (rightMostBigger != -1) {
                swap(nums, breakerIndex, rightMostBigger);
            }
        }
        
        reverse(nums, breakerIndex + 1);
    }
    
    private int findBreakerIndex(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        return i;
    }
    
    private int findRightMostBigger(int[] nums, int target, int start) {
        int i = nums.length - 1;
        
        while (i > start) {
            if (nums[i] > target) {
                return i;
            }
            i--;
        }
        
        return -1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start <= end) {
            swap(nums, start++, end--);
        }
    }
}
