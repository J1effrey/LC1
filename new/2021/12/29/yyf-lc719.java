class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = nums[nums.length - 1] - nums[0];
        while (l < r) {
            int count = 0;
            int j = 0;
            int m = l + ((r - l) >> 1);
            for (int i = 0; i < n; i++) {
                while (j < n && nums[j] - nums[i] <= m) ++j;
                count += j - i - 1;
            }
            if (count >= k) {
                r = m;
            } else {
                l = m + 1;
            } 
        }
        return l;   
    }
}
