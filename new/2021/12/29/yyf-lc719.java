// O(NlogN + NlogR)
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = nums[nums.length - 1] - nums[0];
        while (l <= r) {
            int count = 0;
            int m = l + (r - l) / 2;
            int j = 0;
            for (int i = 0; i < n; i++) {
                while (j < n && nums[j] - nums[i] <= m) {
                    j++;
                }
                count += j - i - 1;
            }
            if (count >= k) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}

/*
n*(n-1)/2
l = 0
r = end - start
m = (l + r) / 2;
count >= k r = m;
          l = m+1;
          
          1 1 3 5 8
S L l
S
*/
