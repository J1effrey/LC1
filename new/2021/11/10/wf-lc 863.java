/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null || target == null) {
            return new ArrayList<>();
        }
        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, null, map);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        
        Set<TreeNode> set = new HashSet<>();
        set.add(null);
        set.add(target);
        
        int distance = 0;
        
        while (!queue.isEmpty() && distance < k) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode temp = map.get(node);
                if (!set.contains(temp)) {
                    set.add(temp);
                    queue.offer(temp);
                }
                if (!set.contains(node.left)) {
                    set.add(node.left);
                    queue.offer(node.left);
                }
                if (!set.contains(node.right)) {
                    set.add(node.right);
                    queue.offer(node.right);
                }
            }
        }
        return queue.stream()
                    .map(n -> n.val)
                    .collect(Collectors.toList());
    }
    
    private void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (node != null) {
            map.put(node, parent);
            dfs(node.left, node, map);
            dfs(node.right, node, map);
        }
    }
}
