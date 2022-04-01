// T: O(N)
// S: O(N)

class Solution {
    public boolean isValidBST(TreeNode root) {    
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, long lowBound, long upBound) {
        if (node == null) {
            return true;
        }
        
        if (node.val >= upBound || node.val <= lowBound) {
            return false;
        }

        return isValidBST(node.left, lowBound, node.val) && isValidBST(node.right, node.val, upBound);
    }
}
