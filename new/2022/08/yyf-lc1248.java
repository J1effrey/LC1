class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    public int atMost(int[] nums, int k) {
        int res = 0;
        int left = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            k -= nums[i] % 2; // 只有是奇数才会k-1
            while (k < 0) k += nums[left++] % 2;
            res += i - left + 1;
        }
        return res;
    }
}
