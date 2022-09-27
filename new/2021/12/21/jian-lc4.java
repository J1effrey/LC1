class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0.0;
        }
        
        if (nums1 == null || nums1.length == 0) {
            return findMedianSingleArray(nums2);
        }
        
        if (nums2 == null || nums2.length == 0) {
            return findMedianSingleArray(nums1);
        } 
        
        if (nums1.length > nums2.length) {
            findMedianSortedArrays(nums2, nums1);
        }
        
        int start = 0;
        int end = nums1.length;
        int expectedNumberOnLeftTotal = (nums1.length + nums2.length + 1) / 2 ;
        
        while (start <= end) {
            int currentNumberOnLeft1 = (start + end) / 2;
            int currentNumberOnLeft2 = expectedNumberOnLeftTotal - currentNumberOnLeft1;
            int l1 = currentNumberOnLeft1 == 0 ? Integer.MIN_VALUE : nums1[currentNumberOnLeft1 - 1];
            int r1 = currentNumberOnLeft1 == nums1.length ? Integer.MAX_VALUE : nums1[currentNumberOnLeft1];
            int l2 = currentNumberOnLeft2 == 0 ? Integer.MIN_VALUE : nums2[currentNumberOnLeft2 - 1];
            int r2 = currentNumberOnLeft2 == nums2.length ? Integer.MAX_VALUE : nums2[currentNumberOnLeft2];
            
            if (l1 <= r2 && l2 <= r1) {
                return ((nums1.length + nums2.length) % 2 == 1) ? Math.max(l1, l2) / 1.0 : (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else {
                if (l1 <= r2) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        return 0.0;
    }
    
    
    private double findMedianSingleArray(int[] nums) {     
        return (nums.length % 2 == 1) ?  nums[nums.length / 2] / 1.0 : (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
    }
}
