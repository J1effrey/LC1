// O(NlogN)
// O(N)
class Solution {
    class SortableElement implements Comparable<SortableElement> {
        int val;
        int level;
        public SortableElement(int val, int level) {
            this.val = val;
            this.level = level;
        }
        
        @Override
        public int compareTo(SortableElement other) {
            if (this.level == other.level) {
                return this.val - other.val;
            }
            
            return this.level - other.level;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList();

        if (root == null) {
          return res;
        }

        Map<Integer, List<SortableElement>> columnTable = new HashMap<>();

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        int startColumn = 0;
        q.offer(new Pair(root, startColumn));

        int minColumn = 0;
        int maxColumn = 0;
        int level = 0;

        while (!q.isEmpty()) { // O(N)
            level++;
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> curPair = q.poll();
                TreeNode curNode = curPair.getKey();
                int curColumn = curPair.getValue();

                columnTable.putIfAbsent(curColumn, new ArrayList<SortableElement>());
                columnTable.get(curColumn).add(new SortableElement(curNode.val, level));;

                minColumn = Math.min(minColumn, curColumn);
                maxColumn = Math.max(maxColumn, curColumn);

                if (curNode.left != null) {
                    q.offer(new Pair(curNode.left, curColumn - 1));
                }

                if (curNode.right != null) {
                    q.offer(new Pair(curNode.right, curColumn + 1));
                }
            }
            
        }
        
        // O(N logN)
        for (int i = minColumn; i < maxColumn + 1; i++) { 
            List<SortableElement> list = columnTable.get(i);
            Collections.sort(list); 
            res.add(list.stream().map(item -> item.val).collect(Collectors.toList()));
        }

        return res;
    }
}

==========
class Solution {
    // 记录每个节点和对应的坐标 (row, col)
    class Triple {
        public int row, col;
        public TreeNode node;

        public Triple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // 遍历二叉树，并且为所有节点生成对应的坐标
        traverse(root, 0, 0);
        // 根据题意，根据坐标值对所有节点进行排序：
        // 按照 col 从小到大排序，col 相同的话按 row 从小到大排序，
        // 如果 col 和 row 都相同，按照 node.val 从小到大排序。
        Collections.sort(nodes, (Triple a, Triple b) -> {
            if (a.col == b.col && a.row == b.row) {
                return a.node.val - b.node.val;
            }
            if (a.col == b.col) {
                return a.row - b.row;
            }
            return a.col - b.col;
        });
        // 将排好序的节点组装成题目要求的返回格式
        LinkedList<List<Integer>> res = new LinkedList<>();
        // 记录上一列编号，初始化一个特殊值
        int preCol = Integer.MIN_VALUE;
        for (int i = 0; i < nodes.size(); i++) {
            Triple cur = nodes.get(i);
            if (cur.col != preCol) {
                // 开始记录新的一列
                res.addLast(new LinkedList<>());
                preCol = cur.col;
            }
            res.getLast().add(cur.node.val);
        }

        return res;
    }

    ArrayList<Triple> nodes = new ArrayList<>();
    // 二叉树遍历函数，记录所有节点对应的坐标
    void traverse(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }
        // 记录坐标
        nodes.add(new Triple(root, row, col));
        // 二叉树遍历框架
        traverse(root.left, row + 1, col - 1);
        traverse(root.right, row + 1, col + 1);
    }
}

