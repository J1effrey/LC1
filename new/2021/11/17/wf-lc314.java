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
