class Solution {
    public int[] findBuildings(int[] heights) {
        if (heights == null || heights.length == 0) {
            return null;
        }
        
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxHeight = -1;
        
        for (int i = n - 1; i >= 0; i--) {
            if (maxHeight < heights[i]) {
                stack.add(i);
                maxHeight = heights[i];
            }
        }
        
        
        int[] answer = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            answer[i++] = stack.pop();
        }
        
        return answer;
    }
}
