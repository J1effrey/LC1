class Solution {
    class TreeElement {
        TreeNode node;
        int column;
        public TreeElement(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }
    
    class ResultElement implements Comparable<ResultElement> {
        int val;
        int level;
        public ResultElement(int val, int level) {
            this.val = val;
            this.level = level;
        }
        
        @Override
        public int compareTo(ResultElement other) {
            if (this.level == other.level) {
                return this.val - other.val;
            }
            
            return this.level - other.level;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeElement> q = new LinkedList<TreeElement>();
        q.offer(new TreeElement(root, 0));
        Map<Integer, List<ResultElement>> m = new HashMap<Integer, List<ResultElement>>();
        int level = 0;
        
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeElement cur = q.poll();
                if (m.containsKey(cur.column)) {
                    List<ResultElement> list = m.get(cur.column);
                    list.add(new ResultElement(cur.node.val, level));
                } else {
                    List<ResultElement> newList = new ArrayList<ResultElement>();
                    newList.add(new ResultElement(cur.node.val, level));
                    m.put(cur.column, newList);
                }
                
                if (cur.node.left != null) {
                    q.offer(new TreeElement(cur.node.left, cur.column - 1));
                }
                
                if (cur.node.right != null) {
                    q.offer(new TreeElement(cur.node.right, cur.column + 1));
                }
            }
        }
        
        List<Integer> keys = new ArrayList<Integer>(m.keySet());
        Collections.sort(keys);
        
        for (Integer key: keys) {
            List<ResultElement> list = m.get(key);
            Collections.sort(list);
            res.add(list.stream().map(l -> l.val).collect(Collectors.toList()));
        }

        return res;
    }
}
