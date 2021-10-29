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
