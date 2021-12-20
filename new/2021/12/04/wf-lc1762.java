class Solution {    
    public int[] findBuildings(int[] heights) {
        if (heights == null || heights.length == 0) {
            return new int[0];
        }
        
        Stack<Integer> stack = new Stack<>();
        int maxHeight = Integer.MIN_VALUE;
        
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                stack.add(i);
                maxHeight = heights[i];
            }
        }
        
        int[] res = new int[stack.size()];
        
        int i = 0;
        
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }
        
        return res;
    }
}
