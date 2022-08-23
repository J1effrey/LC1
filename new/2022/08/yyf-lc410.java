class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().getAsInt();
        return binary(nums, m, sum, max);
    }
    
    public int binary(int[] nums, int m, int right, int left) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isValid(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public boolean isValid(int[] nums, int m, int subArraySum) {
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > subArraySum) {
                count++;
                sum = num;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
