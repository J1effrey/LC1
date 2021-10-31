class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] minLast = new int[nums.length + 1];
        minLast[0] = Integer.MIN_VALUE;
        
        for (int i = 1; i < minLast.length; i++) {
            minLast[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int index = binarySearch(minLast, nums[i]);
            minLast[index] = nums[i];
        }
        
        for (int i = minLast.length - 1; i > 0; i--) {
            if (minLast[i] != Integer.MAX_VALUE) {
                return i;
            }
        }
        return 0;
    }
    
    private int binarySearch(int[] nums, int num) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
