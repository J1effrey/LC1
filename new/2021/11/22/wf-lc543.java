class Solution {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;     
    }
}
