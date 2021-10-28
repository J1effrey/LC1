/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

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

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
