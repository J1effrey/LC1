/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node prev = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        
        Node dummyNode = new Node(0);
        prev = dummyNode;
        inOrder(root);
        
        dummyNode.right.left = prev;
        prev.right = dummyNode.right;
        
        return dummyNode.right;
    }
    
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        
        inOrder(node.left);
        prev.right = node;
        node.left = prev;
        prev = node;
        inOrder(node.right);
    }
}
