// T: O(k), K is length of nums1
// S: O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return;
        }
        int index = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] < nums2[n - 1]) {
                nums1[index] = nums2[n - 1];
                n--;
            } else {
                nums1[index] = nums1[m - 1];
                m--;
            }
            index--;             
        }
        
        while (n > 0) {
            nums1[index] = nums2[n - 1];
            n--;
            index--;
        }
    }
}
