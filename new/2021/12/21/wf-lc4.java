class Solution {
    /*
    A: 1，2   A[k/2] < B[k/2]
    B: 3，4   
    --   --
    --   --
    K = k/2 + k/2 
    
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }
        
        int len = nums1.length + nums2.length;
        
        if (len % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        }
        return (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        
    }
    
    private int findKth(int[] nums1, int startOfNums1, int[] nums2, int startOfNums2, int k) {
        if (startOfNums1 >= nums1.length) {
            return nums2[startOfNums2 + k - 1];
        }
        if (startOfNums2 >= nums2.length)  {
            return nums1[startOfNums1 + k - 1];
        }
        
        if (k == 1) {
            return Math.min(nums1[startOfNums1], nums2[startOfNums2]);
        }
        
        int startIndexOfNums1 = startOfNums1 + k / 2 - 1;
        int startKeyOfNums1 = startIndexOfNums1 < nums1.length
            ? nums1[startIndexOfNums1]
            : Integer.MAX_VALUE;
        int startIndexOfNums2 = startOfNums2 + k / 2 - 1;
        int startKeyOfNums2 = startIndexOfNums2 < nums2.length
            ? nums2[startIndexOfNums2]
            : Integer.MAX_VALUE;
        
        if (startKeyOfNums1 < startKeyOfNums2) {
            return findKth(nums1, startOfNums1 + k / 2, nums2, startOfNums2, k - k / 2);
        }
        return findKth(nums1, startOfNums1, nums2, startOfNums2 + k / 2, k - k / 2);
    }
    
//     A[k/2] > B[k/2]
//         4
//         2
//     1,2 : 1   2
//     3,4   3   4
//     len of num1 + len of num2: (lenOfNums1 + lenOfNums2) / 2
//     : 2th 3rd
}
