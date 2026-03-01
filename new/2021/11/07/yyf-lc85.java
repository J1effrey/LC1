//Time: O(n^2)
//Space: O(n)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = (matrix[i][j] == '0') ? 0 : heights[j] + 1;
            }
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int res = 0;
        var s = new ArrayDeque<Integer>();
        
        for (int i = 0; i <= heights.length; i++) {
            int cur = (i == heights.length) ? 0 : heights[i];

            if (s.isEmpty() || cur >= heights[s.peek()]) {
                s.push(i);
                continue;
            }

            int right = i;

            while (!s.isEmpty() && cur < heights[s.peek()]) {
                int mid = s.pop();
                int midH = heights[mid];
                int left = s.isEmpty() ? -1 : s.peek();

                res = Math.max(res, (right - left - 1) * midH);
            }

            s.push(i);
        }

        return res;
    }
}


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
