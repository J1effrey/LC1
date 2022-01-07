class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] tails = new int[nums.length]; // dp[i] / tails[i] : the smallest ending number of sub-sequence [0, i], i included 
        tails[0] = nums[0];
        int size = 1;
        
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int start = 0;
            int end = size - 1;
            
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (tails[mid] <= cur) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            
            if (cur > tails[end]) {
                tails[end + 1] = cur;
                size++;
            } else if (cur > tails[start] && cur <= tails[end]) {
                tails[end] = cur;
            } else {
                tails[start] = cur;
            }
        }
        
        return size;
    }
}

===

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


/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0;
            int j = size;
            while (i != j) {
                int m = (j + i) / 2;
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[j] = x;
            if (j == size) size++;
        }
        return size;
    }
}
// [2,3,7,101,18]

*/
