class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        int right = n - 1;
        int left = 0;

        
        while (left + 1 < right) {
            while (left + 1 < right && nums[left] == nums[left + 1]) {
                left++;
            }
            while (left + 1 < right && nums[right] == nums[right - 1] ) {
                right--;
            }
            if (left + 1 >= right) break;
            
            int mid = (right - left) / 2 + left;
            
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid;
                }
                else {
                    left = mid;
                }
            }
            // mid to right ordered
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid;
                }
                else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target || nums[right] == target) {
            return true;
        }
        return false;
    }
}
