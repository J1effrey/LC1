class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int nonZeroP = 0;
        int zeroP = 0;
        
        
        while (nonZeroP < nums.length) {
            if (nums[nonZeroP] != 0) {
                swap(nums, nonZeroP, zeroP);
                zeroP++;
            }
            nonZeroP++;
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}


===========
    
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
            
            if (windowSize > 0) {
                swap(nums, i - windowSize, i);
            }
        }
    }
    
    private void swap(int[] nums, int indexA, int indexB) {
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }
}
