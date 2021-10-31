class Solution {
    int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        helper(root);
        return res;
        
    }
    
    /*
    return max path, must contains the current node as root
    */
    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        
        res = Math.max(res, left + right + node.val);
        
        return node.val + Math.max(left, right);
        
    }
}
