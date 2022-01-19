// bfs
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur == null) {
                    sb.append('#');
                } else {
                    sb.append(cur.val);
                }    
                
                if (cur != null) {
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
                
                if (!q.isEmpty()) {
                    sb.append(',');
                }
            }
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        
        String[] strs = data.split(",");
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        q.offer(root);
        
        for (int i = 1; i < strs.length; i++) {
            TreeNode cur = q.poll();
            if (!strs[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(strs[i]));
                cur.left = left;
                q.add(left);
            } 
            i++;
            if (!strs[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(strs[i]));
                cur.right = right;
                q.add(right);
            }
        }

        return root;
    }
}

----------------------------------------------------------------------------------------------------------------------------------------
// dfs
public class Codec {
    private String serialize(TreeNode root) {
        if (root == null) {
            return "null ";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return String.valueOf(root.val) + " " + left + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(" ");
        int[] d = new int[1];
        return dfs(nodes, d);
    }
    
    private TreeNode dfs(String[] nodes, int[] d) {
        if (d[0] > nodes.length || nodes[d[0]].equals("null")) {
            d[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[d[0]]));
        d[0]++;
        root.left = dfs(nodes, d);
        root.right = dfs(nodes, d);
        return root;
    }
}

/*
    Root -> left Node -> right Node
    1 -> 2 -> 3
    
    1 -> 2 -> null -> null -> 3 -> 4 -> null -> null -> 5 -> null -> null
String: [1 -> 2 -> null -> null -> 3 -> 4 -> null -> null  5  null  null]
    root = 1
    left = [2 -> null -> null -> 3 -> 4 -> null -> null  5  null  null];
    right = [3 -> 4 -> null -> null  5  null  null]
        left: 3
            left 4
                left: null right: null 
        right: 5 [5  null  null]
            left null
            right null
*/

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
