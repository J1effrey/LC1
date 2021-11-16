class Solution {    
    public int missingElement(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int missCount = getMissCount(mid, nums);
            
            if (missCount > k) {
                end = mid;
            } else if (missCount == k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (k > getMissCount(end, nums)) {
            return nums[end] + (k - getMissCount(end, nums));
        }
        
        return nums[start] + (k - getMissCount(start, nums));
       
    }
    
    private int getMissCount(int index, int[] nums) {
        return nums[index] - nums[0] - index;
    }
}
