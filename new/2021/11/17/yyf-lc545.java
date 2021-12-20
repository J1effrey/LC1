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
    List<Integer> nodes;
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        nodes = new ArrayList<>();
        
        if (root == null) {
            return nodes;
        }

        nodes.add(root.val);
        addLeftBoundary(root.left);
        addLeaves(root.left);
        addLeaves(root.right);
        addRightBoundary(root.right);

        return nodes;
    }
    
    public void addLeftBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        
        nodes.add(root.val);
        if (root.left == null) {
            addLeftBoundary(root.right);
            return;
        }
        
        addLeftBoundary(root.left);
    }
    
    public void addRightBoundary(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return;
        }
        if (root.right == null) {
            addRightBoundary(root.left);
        } else {
            addRightBoundary(root.right);
        }
        nodes.add(root.val); // add after child visit(reverse)
    }
    
    public void addLeaves(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            nodes.add(root.val);
            return;
        }
        
        addLeaves(root.left);
        addLeaves(root.right);
    }
}

/*
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
*/
/*
1 2 4 7 8 

*/
