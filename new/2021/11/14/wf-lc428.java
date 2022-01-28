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
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        sb.append(root.val);
        sb.append("#");
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node curr = queue.poll();
                List<Node> children = curr.children;
                if (children == null || children.size() == 0) {
                    sb.append("null");
                } else {
                    for (int i = 0; i < children.size(); i++) {
                        Node child = children.get(i);
                        sb.append(child.val);
                        if (i != children.size() - 1) {
                            sb.append(",");
                        }  
                        queue.offer(child);
                    }
                }
                if (!queue.isEmpty()) {
                    sb.append("#");
                }  
            }
        }
        String data = sb.toString();
        return data;
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] elements = data.split("#");
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(elements[0]), null);
        queue.offer(root);
        for (int i = 1; i < elements.length; i++) {
            Node parent = queue.poll();
            List<Node> children = new ArrayList<>();
            String[] kids = elements[i].split(",");
            for (String kid : kids) {
                if ("null".equals(kid)) {
                    continue;
                }
                if (kid.length() == 0) {
                    continue;
                }
                Node n = new Node(Integer.parseInt(kid), null);
                queue.offer(n);
                children.add(n);
            }
            parent.children = children;
            
        }
        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
