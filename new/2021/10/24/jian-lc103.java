class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int level = 0;
        
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            List<Integer> cur = new ArrayList<Integer>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                insertNode(cur, node.val, level % 2 == 0);    
                if (node.left != null) {
                    q.offer(node.left);
                }
                
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(cur);
        }
        
        return res;
    }
    
    private void insertNode(List<Integer> list, int val, boolean shouldReverse) {
        if (shouldReverse) {
            list.add(0, val);
            return;
        } 
        
        list.add(val);
    }
    
}
