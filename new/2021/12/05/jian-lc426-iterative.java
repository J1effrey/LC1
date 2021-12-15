class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        Node start = root;
        while (start.left != null) {
            start = start.left;
        }
        Node prev = null;
        Stack<Node> stack = new Stack<Node>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (prev != null) {
                prev.right = cur;
                cur.left = prev;
            }
            prev = cur;
            cur = cur.right;
        }
        start.left = prev;
        prev.right = start;
        return start;
    }
}
