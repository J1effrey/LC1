// T:O(N)
// S:O(N)
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int N = height.length;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int pre = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int minHeight = Math.min(height[stack.peek()], height[i]);
                res += (minHeight - height[pre]) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return res;
    }
}

/*
 2 1 0 1 3
 2 1 0
 2(1 0 1)
 2(1   1 3)
(2 1     3)
*/
