// T: O(k), K is length of nums1
// S: O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0) {
            return;
        }
        
        if (nums2 == null || nums2.length == 0) {
            return;
        }
        
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;
        
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[index--] = nums1[p1--];
                continue;
            }
            
            nums1[index--] = nums2[p2--]; 
        }
        
        while (p1 >= 0) {
            nums1[index--] = nums1[p1--];
        }
        
        while (p2 >= 0) {
            nums1[index--] = nums2[p2--]; 
        }
    }
}
