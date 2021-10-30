class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        
        int length = nums.length;
        int[] res = new int[length];
        res[0] = 1;
        int right = 1;
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        for (int i = length - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        
        return res;
    }
}