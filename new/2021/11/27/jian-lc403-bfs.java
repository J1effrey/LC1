class Solution {
    
    //用Jump来记录上一跳的距离和当前坐标，记录上一跳的距离是为了推算下一步能跳到哪
    class Jump {
        int len;
        int idx;
        public Jump(int l, int i) {
            len = l;
            idx = i;
        }
    }
    /**
     * @param stones: a list of stones' positions in sorted ascending order
     * @return: true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        // write your code here
        if (stones == null || stones.length == 0) {
            return false;
        }
        
        Queue<Jump> queue = new LinkedList();
        //初始化上一跳是0（下一跳可以是0+1=1）,当前位置是0
        queue.offer(new Jump(0, 0));
        int target = stones[stones.length - 1];
        //把石头的坐标集合化，方便判断该青蛙能否停在该坐标上
        Set<Integer> positions = new HashSet();
        for (Integer i : stones) {
            positions.add(i);
        }
        //记忆化剪枝用的visited，记录上一跳的距离和当前坐标，用于去重
        Set<String> visited = new HashSet();
        visited.add(0 + "_" + 0);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Jump jump = queue.poll();
                //如果到达目标就返回true
                if (jump.idx == target) {
                    return true;
                }
                //否则按照上一跳的距离和当前坐标，推算当前能跳的距离和可以到达的坐标
                for (int k = -1; k <= 1; k++) {
                    int len = jump.len + k;
                    int idx = jump.idx + len;
                    //题目要求必须向前跳，所以距离必须大于等于1
                    if (len < 1) {
                        continue;
                    }
                    //如果下一步可以到达的坐标上没有石头就略过
                    if (!positions.contains(idx)) {
                        continue;
                    }
                    //如果距离和坐标的组合以前曾经加入过对列也略过
                    if (visited.contains(len + "_" + idx)){
                        continue;
                    }
                    //把新的Jump对象放入队列，并标记为已访问
                    queue.offer(new Jump(len, idx));
                    visited.add(len + "_" + idx);
                }
            }
        }
        return false;
    }
}
