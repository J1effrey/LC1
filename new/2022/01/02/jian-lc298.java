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
class Solution {
    int res = 0;
    
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        helper(root);
        return res;
    }
    
    private int helper(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 1;
        }
        
        int leftPath = 0;
        if (node.left != null) {
            int leftLength = helper(node.left);
            if (node.left.val - node.val == 1) {
                leftPath = leftLength;
            }
        }
        
        int rightPath = 0;
        if (node.right != null) {
            int rightLength = helper(node.right);
            if (node.right.val - node.val == 1) {
                rightPath = rightLength;
            }
        }
        
        int curLongestPath = Math.max(1 + leftPath, 1 + rightPath);
        res = Math.max(res, curLongestPath);
        
        return curLongestPath;
    }
}
