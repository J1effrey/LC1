// Time: O(n)
// Space: O(n)

// 1 11 12 5 7 6 4 3 2
// index: 5 (6)
// 1 11 12 6 7 5 4 3 2
// 1 11 12 6 2 3 4 5 

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int breakerIndex = findBreakerIndex(nums);
        
        if (breakerIndex == -1) {
            reverse(nums, breakerIndex + 1);
            return;
        }
        
        int rightMostBigger = findRightMostBigger(nums, nums[breakerIndex], breakerIndex);
        swap(nums, breakerIndex, rightMostBigger);
        
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
