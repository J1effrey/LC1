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
  public int countNodes(TreeNode root) {
    return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
  }
}

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getSubtreeHeight(root, true);
        int right = getSubtreeHeight(root, false);
        //如果最后一层是满node，只遍历了最左和最右两条路径
        if (left == right) {
            int res = (int)(Math.pow(2, left)) - 1;
            return res;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    private int getSubtreeHeight(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        int height = 0;
        while (node != null) {
            height++;
            if (isLeft) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return height;
    }
}
