// T: O(N)
// S: O(N)

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidHelper(TreeNode node, long min,long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        
        return isValidHelper(node.left, min, node.val) && isValidHelper(node.right, node.val, max);
    }
}
