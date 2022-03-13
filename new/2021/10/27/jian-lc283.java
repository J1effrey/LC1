// minimum total number of operations done
// O(n)
// O(1)
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int windowSize = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                windowSize++;
                continue;
            }    
            
            int windowStart = i - windowSize;
            swap(nums, windowStart, i);
        }
    }
    
    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
