class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return "";
        }
        
        partition(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
    }
    
    private void partition(String[] nums, int start, int end, int k) {
        if (start == end) {
            return;
        }
        
        int left = start;
        int right = end;
        String pivot = nums[left + (right - left) / 2];
          
        while (left <= right) {          
            while (left <= right && compareStrNum(nums[left], pivot) == -1) {
                left++;
            }  
            while (left <= right && compareStrNum(nums[right], pivot) == 1) {
                right--;
            }
            if (left <= right) {
                swap(nums, left++, right--);
            }
        }
        
        if (k <= right) {
            partition(nums, start, right, k);
        } else if (k >= left) {
            partition(nums, left, end, k);
        }       
    }

    private int compareStrNum(String a, String b) {
        int sign = 1;
        int res = 0;
        
        if (a.charAt(0) != '-' && b.charAt(0) == '-') {
            return 1;
        }
        
        if (a.charAt(0) == '-' && b.charAt(0) != '-') {
            return -1;
        }
        
        if (a.charAt(0) == '-' && b.charAt(0) == '-') {
            sign = -1;
        }
        
        if (a.length() != b.length()) {
            res = a.length() > b.length() ? 1 : -1;
            return res * sign;
        }
        
        int pa = 0;
        int pb = 0;
        
        while (pa < a.length() && pb < b.length()) {
            if (a.charAt(pa) > b.charAt(pb)) {
                res = 1;
                return sign * res;
            } else if (a.charAt(pa) < b.charAt(pb)) {
                res = -1;
                return sign * res;
            }
            pa++;
            pb++;
        }
        
        return 0;
    }
    
    private void swap(String[] nums, int a, int b) {
        String temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
