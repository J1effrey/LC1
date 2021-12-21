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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        helper(root, set, res);
        if (!set.contains(root.val)) {
            res.add(root);
        }
        return res;
    }
    
    public TreeNode helper(TreeNode node, Set<Integer> set, List<TreeNode> res) {
        if (node == null) {
            return null;
        }
        node.left = helper(node.left, set, res);
        node.right = helper(node.right, set, res);
        if (set.contains(node.val)) {
            if (node.left != null) {
                res.add(node.left);
            }
            if (node.right != null) {
                res.add(node.right);
            }
            return null;
        }
        return node;
    }
}
