/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            sb.append(curr.val);
            sb.append(",");
            sb.append(curr.children.size());
            for (Node node: curr.children) {
                queue.offer(node);
            }
            if (!queue.isEmpty()) {
                sb.append(",");
            }  
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        
        String[] nodes = data.split(",");
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> childQueue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(nodes[0]));
        childQueue.offer(Integer.parseInt(nodes[1]));
        queue.offer(root);
        int index = 2;
        
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            curr.children = new ArrayList<>();
            int size = childQueue.poll();
            for (int i = 0; i < size; i++) {
                Node node = new Node(Integer.parseInt(nodes[index]));
                index++;
                childQueue.offer(Integer.parseInt(nodes[index]));
                index++;
                queue.offer(node);
                curr.children.add(node);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
