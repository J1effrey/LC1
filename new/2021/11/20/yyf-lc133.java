/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// T:O(E)
// S:O(V)
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        
        HashMap<Node, Node> visited = new HashMap();
        LinkedList<Node> queue = new LinkedList<Node> ();
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList()));

        while (!queue.isEmpty()) {
            Node n = queue.remove();
            for (Node neighbor: n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    queue.add(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}
