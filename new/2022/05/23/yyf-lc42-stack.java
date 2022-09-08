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

----------------------------------------------------------------------------------------------------------------
class Solution {
    // DP 递减栈，需要三个元素来储存水，左墙壁，湖底，右墙壁
    // height [2,1,0,1,3]
    // stack [2,1,0]
    // stack [2(1,0,1)]      湖底高度为0，(101)储存水     water += 1
    // stack [2(1,  1,3)]    湖底高度为1，(113)没有储存水     water += 1
    // stack [(2,1,    3)]    湖底高度为1，(213)储存水     water += (高度差1) * (长度3)
    // 最后结果为4
    
    // 为什么不用递增栈，因为递增栈不储水
    // 1. 保持递减栈
    // 2. 拿结果
    // 3. push当前element进stack，这里进入的current element一定合法的，因为第一步已经处理过了
    
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        int N = height.length;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int lakeHeightIndex = stack.pop();
                if (stack.isEmpty()) break;
                int leftWallIndex = stack.peek();
                int depth = Math.min(height[leftWallIndex], height[i]) - height[lakeHeightIndex];
                int width = i - leftWallIndex - 1;
                res += depth * width;
            }
            stack.push(i);
        }
        return res;
    }
}
