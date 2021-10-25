class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> s = new Stack<Integer>();
        s.push(-1);
        int res = 0;
        
        for (int i = 0; i < heights.length; i++) {
            if (s.peek() == -1) {
                s.push(i);
            } else {
                if (heights[i] >= heights[s.peek()]) {
                    s.push(i);
                } else {
                    while (s.peek() != -1 && heights[i] < heights[s.peek()]) {
                        int cur = s.pop();
                        res = Math.max(res, (i - s.peek() - 1) * heights[cur]);
                    }
                    s.push(i);
                }
            }
        }
        
        while (!s.isEmpty()) {
            int cur = s.pop();
            if (cur != -1) {
                res = Math.max(res, (heights.length - s.peek() - 1) * heights[cur]); 
            }
        }
        
        return res;
    }
}
