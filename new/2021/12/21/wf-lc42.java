class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        
        int res = 0;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 1;
        int right = height.length - 2;
        
        while (left <= right) {
            
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }
        
        return res;
    }
}
