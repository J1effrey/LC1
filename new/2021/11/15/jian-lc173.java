class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode cur = stack.pop();
        TreeNode next = cur.right;
        while (next != null) {
            stack.push(next);
            next = next.left;
        }
        return cur.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
