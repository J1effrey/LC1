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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        check(root.left, res, true, false);
        check(root.right, res, false, true);
        return res;
    }
    
    public void check(TreeNode node, List<Integer> res, boolean isLeft, boolean isRight) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }
        if (isLeft) {
            res.add(node.val);
        }
        check(node.left, res, isLeft && node.left != null, isRight && node.right == null);
        check(node.right, res, isLeft && node.left == null, isRight && node.right != null);
        if (isRight) {
            res.add(node.val);
        }
     }
}

/*
1 2 4 7 8 

*/
