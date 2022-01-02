// Time complexity: O(n) - we run on the entire tree once. Our map acts as memoization to prevent redoing work.
// Space copmlexity: O(n) - We're creating a hashmap to save all nodes in the tree.

// 1 pass
class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node,NodeCopy> map = new HashMap<>();
        return dfs(root, map);
    }
    
    public NodeCopy dfs(Node root, Map<Node,NodeCopy> map){
        if (root == null) {
            return null;        
        }
        
        // One edge case to notice is that if there's a cycle in the tree 
        if (map.containsKey(root)) {
            return map.get(root);
        }
        
        NodeCopy newNode = new NodeCopy(root.val);
        map.put(root, newNode);
        
        newNode.left = dfs(root.left, map);
        newNode.right = dfs(root.right, map);
        newNode.random = dfs(root.random, map);
        
        return newNode;
        
    }
}

// T: O(2n) - > O(n)
// S: O(n)

// 2 passes
class Solution {
    Map<Node, NodeCopy> m = new HashMap<>();
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) {
            return null;
        }
        
        NodeCopy rootCopy = new NodeCopy(root.val);
        m.put(root, rootCopy);
        
        copyLeftRight(root, rootCopy);
        copyRandom(root, rootCopy);
        
        return rootCopy;
    }
    
    private void copyLeftRight(Node node, NodeCopy nodeCopy) {
        if (node == null) {
            return;
        }
        
        if (node.left != null) {
            nodeCopy.left = new NodeCopy(node.left.val);
            m.put(node.left, nodeCopy.left);
        }
        
        if (node.right != null) {
            nodeCopy.right = new NodeCopy(node.right.val);
            m.put(node.right, nodeCopy.right);
        }
        
        copyLeftRight(node.left, nodeCopy.left);
        copyLeftRight(node.right, nodeCopy.right);
    }
    
    private void copyRandom(Node node, NodeCopy nodeCopy) {
        if (node == null) {
            return;
        }
        nodeCopy.random = m.get(node.random);
        
        copyRandom(node.left, nodeCopy.left);
        copyRandom(node.right, nodeCopy.right);
    }
    
}
