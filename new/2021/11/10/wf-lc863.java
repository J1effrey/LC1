/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// T:O(N)
// S:O(N)
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null || target == null) {
            return new ArrayList<>();
        }
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        dfs(root, null, parents);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        
        Set<TreeNode> set = new HashSet<>();
        set.add(target);
        
        int distance = 0;
        
        while (!queue.isEmpty() && distance < k) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode temp = parents.get(node);
                if (temp != null && !set.contains(temp)) {
                    set.add(temp);
                    queue.offer(temp);
                }
                if (node.left != null && !set.contains(node.left)) {
                    set.add(node.left);
                    queue.offer(node.left);
                }
                if (node.right != null && !set.contains(node.right)) {
                    set.add(node.right);
                    queue.offer(node.right);
                }
            }
        }
        return queue.stream()
                    .map(n -> n.val)
                    .collect(Collectors.toList());
    }
    
    private void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parents) {
        if (node != null) {
            parents.put(node, parent);
            dfs(node.left, node, parents);
            dfs(node.right, node, parents);
        }
    }
}
