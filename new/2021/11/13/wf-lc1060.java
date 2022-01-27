// T: O(logN)
// S: O(1)
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


-------------------------------------------------
class Solution {
    public int missingElement(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midMissing = getMissingCounts(nums, mid);
            if (midMissing < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return getMissingCounts(nums, left) < k ? nums[left] + (k - getMissingCounts(nums, left)) : nums[left] - (getMissingCounts(nums, left) - k + 1);
    }
    
    public int getMissingCounts(int[] nums, int i) {
        return nums[i] - nums[0] - i;
    }
}
