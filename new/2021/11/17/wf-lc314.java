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

// O(N), N is number of nodes in tree
// O(N)
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();

        if (root == null) {
          return res;
        }

        Map<Integer, ArrayList> columnTable = new HashMap<>();

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        int startColumn = 0;
        q.offer(new Pair(root, startColumn));

        int minColumn = 0;
        int maxColumn = 0;

        while (!q.isEmpty()) { // O(N)
            Pair<TreeNode, Integer> curPair = q.poll();
            TreeNode curNode = curPair.getKey();
            int curColumn = curPair.getValue();

            columnTable.putIfAbsent(curColumn, new ArrayList<Integer>());
            columnTable.get(curColumn).add(curNode.val);
            
            minColumn = Math.min(minColumn, curColumn);
            maxColumn = Math.max(maxColumn, curColumn);
            
            if (curNode.left != null) {
                q.offer(new Pair(curNode.left, curColumn - 1));
            }
            
            if (curNode.right != null) {
                q.offer(new Pair(curNode.right, curColumn + 1));
            }
        }

        for (int i = minColumn; i < maxColumn + 1; i++) { // worst O(N)
          res.add(columnTable.get(i));
        }

        return res;
    }
}
