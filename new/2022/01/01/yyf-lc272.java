// O(N)
// O(K)
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(res, root, target, k);
        return res;
    }
    
    public void helper(LinkedList<Integer> res, TreeNode node, double target, int k) {
        if (node == null) {
            return;
        }
        helper(res, node.left, target, k);
        if (res.size() == k) {
            if (Math.abs(node.val - target) < Math.abs(res.peekFirst() - target)) {
                res.removeFirst();
            } else {
                return;
            }
        }
        res.add(node.val);
        helper(res, node.right, target, k);
    }
}
