class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return 0;
        }
        
        int m = nums.length - k;    
        
        return partition(nums, 0, nums.length - 1, m);
    }
    
    private int partition(int[] nums, int start, int end, int m) {
        int left = start;
        int right = end;
        
        if (left == right) {
            return nums[m];
        }
        
        int pivot = nums[left + (end - left) / 2];
        
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        
        if (m <= right) {
            return partition(nums, start, right, m);
        }
        
        return partition(nums, left, end, m);
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
