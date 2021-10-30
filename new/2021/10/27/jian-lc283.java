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
