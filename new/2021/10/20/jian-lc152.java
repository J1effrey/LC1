// T: O(n)
// S: O(1)

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = nums[0];
        int preMin = nums[0];
        int preMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int c1 = nums[i];
            int c2 = nums[i] * preMin;
            int c3 = nums[i] * preMax;
            res = Math.max(res, max3(c1, c2 ,c3));
            preMax = max3(c1, c2, c3);
            preMin = min3(c1, c2, c3);
        }
        
        return res;
    }
    
    private int max3(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }
    
    private int min3(int num1, int num2, int num3) {
        return Math.min(Math.min(num1, num2), num3);
    }
}
