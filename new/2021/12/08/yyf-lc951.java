/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// T:O(min{N1,N2)) n is length
// S:O(min{h1,h2}) h is height
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        
        if (root1 == null || root2 == null) {
            return false;
        }
        
        if (root1.val != root2.val) {
            return false;
        }
        
        boolean isSame = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean isFlip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        
        return isSame || isFlip;
    }
}

/*
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        boolean left1MatchLeft2 = flipEquiv(root1.left, root2.left);
        boolean righ1MatchtRight2 = flipEquiv(root1.right, root2.right);
        boolean left1MatchRight2 =  flipEquiv(root1.left, root2.right);
        boolean right1MatchLeft2 = flipEquiv(root1.right, root2.left);
        return (left1MatchLeft2 && righ1MatchtRight2) || (left1MatchRight2 && right1MatchLeft2);
    }
}
*/
/*
left1-left2  right1-right2
left1-right2 right1-left2
*/
