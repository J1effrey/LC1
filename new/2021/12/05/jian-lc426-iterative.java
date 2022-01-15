// T: O(N)
// S: O(N)

class Solution {
    // the smallest (first) and the largest (last) nodes
    Node prev = null;
    
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node(0);
        prev = dummy;
        
        helper(root);
        
        // close DLL
        Node first = dummy.right;
        prev.right = first;
        first.left = prev;
        
        return first;
    }

    public void helper(Node node) {
        if (node == null) {
            return;
        }
        
        // left
        helper(node.left);
            
        // node
        prev.right = node;
        node.left = prev;
        prev = node;
        
        // right
        helper(node.right);
    }
}


===
    
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
