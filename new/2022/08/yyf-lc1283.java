class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 1;
        int right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left < right) {
            int mid = (right + left) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += num % mid == 0 ? num / mid : num / mid + 1;
            }
            if (sum <= threshold) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
