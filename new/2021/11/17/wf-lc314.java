/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        queue.offer(root);
        cols.offer(0);
        
        while (!queue.isEmpty()) {
            int col = cols.poll();
            TreeNode node = queue.poll();
            
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            
            map.get(col).add(node.val);
            
            if (node.left != null) {
                queue.offer(node.left);
                cols.offer(col - 1);
            }
            
            if (node.right != null) {
                queue.offer(node.right);
                cols.offer(col + 1);
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        int min = Collections.min(map.keySet());
        int max = Collections.max(map.keySet());
        
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        
        return res;
    }
}

------------
    class Solution {
    int min = 0;
    int max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        computeRange(root, 0);
        for (int i = min; i <= max; i++) {
            res.add(new ArrayList<>());
        }
        // -2 -1 0 1 2
        //  0 1 2 3 4
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        nodes.offer(root);
        cols.offer(-min);
        while (!nodes.isEmpty()) {
            TreeNode currNode = nodes.poll();
            int currCol = cols.poll();
            res.get(currCol).add(currNode.val);
            if (currNode.left != null) {
                nodes.offer(currNode.left);
                cols.offer(currCol - 1);
            }
            if (currNode.right != null) {
                nodes.offer(currNode.right);
                cols.offer(currCol + 1);
            }
        }
        
        return res;
    }
    
    public void computeRange(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        min = Math.min(min, index);
        max = Math.max(max, index);
        computeRange(root.left, index - 1);
        computeRange(root.right, index + 1);
    }
}
