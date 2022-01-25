//Time: O(n^2)
//Space: O(n)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        Stack<Integer> stack;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] dp = new int[cols];
        int maxArea = 0;
        for (int i =  0; i < rows; i++) {
            stack = new Stack<>();
            for (int j = 0; j <= cols; j++) {
                if (j != cols) {
                    dp[j] = matrix[i][j] == '0' ? 0 : dp[j] + 1;
                }
                while (!stack.isEmpty() && (j == cols || dp[stack.peek()] > dp[j])) {
                    int height = dp[stack.pop()];
                    int width = stack.isEmpty() ? j : j - stack.peek() - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(j);
            }
        }
        
        return maxArea;
    }
}

/*
1 0 1 0 0
stack: 0 0 0 
1 1 0 0 0 -> 1

2 0 2 1 1 -> 3

3 1 3 2 2 -> 6
*/
