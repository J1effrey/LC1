class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int N = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
