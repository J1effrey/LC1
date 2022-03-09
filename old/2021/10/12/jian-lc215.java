class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return 0;
        }
        
        partition(nums, 0, nums.length - 1, k - 1);
        return nums[k - 1];
    }
    
    private void partition(int[] nums, int start, int end, int k) {
        if (start == end) {
            return;
        }
        
        int left = start;
        int right = end;
        
        int pivot = nums[left + (end - left) / 2];
        
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        
        if (k <= right) {
            partition(nums, start, right, k);
            return;
        }
        
        partition(nums, left, end, k);
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
