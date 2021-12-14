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
