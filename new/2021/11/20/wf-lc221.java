class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null ||  matrix[0].length == 0) {
            return 0;
        }
        int[] hist = new int[matrix[0].length];
        
        int maxLength = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                hist[j] = matrix[i][j] == '1' ? hist[j] + 1 : 0;
            }
            maxLength = Math.max(maxLength, largestSquareLength(hist));
        }
        
        return maxLength * maxLength;
    }
    
    public int largestSquareLength(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        
        for (int i = 0; i <= heights.length; i++) {
            int curr = i == heights.length ? -1 : heights[i];
            while (!stack.isEmpty() && curr <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                //res = Math.max(res, height * width);
                if (height >= width) {
                    res = Math.max(res, width);
                }
                
            }
            stack.push(i);
        }
        
        return res;
    }
}
