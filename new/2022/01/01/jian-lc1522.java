class Solution {
    int res = 0;
    
    public int diameter(Node root) {
        if (root == null) {
            return res;
        }
        
        helper(root);
        
        return res - 1;
    }
    
    private int helper(Node node) {
        if (node == null) {
            return 0;
        }
        
        int max1 = 0;
        int max2 = 0;
        
        for (Node child: node.children) {
            int curLen = helper(child);
            if (curLen > max1) {
                max2 = max1;
                max1 = curLen;
            } else if (curLen > max2) {
                max2 = curLen;
            }
        }
        
        res = Math.max(res, 1 + max1 + max2);
        
        return 1 + max1;
    }
}
