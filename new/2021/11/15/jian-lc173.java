
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    private void pushLeftBranch(TreeNode p) {
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    public BSTIterator(TreeNode root) {
        pushLeftBranch(root);
    }

    public int next() {
        TreeNode p = stack.pop();
        pushLeftBranch(p.right);
        return p.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
