class Solution {
    Set<Integer> set = new HashSet<>();
    Map<String, Boolean> map = new HashMap<>();
    int target;
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }
        target = stones[stones.length - 1];
        for (int stone : stones) {
            set.add(stone);
        }
        return dfs(1, 1);
    }
    
    public boolean dfs(int currPosition, int prevJumpStep) {
        if (!set.contains(currPosition) || prevJumpStep == 0) {
            return false;
        }
        if (currPosition == target) {
            return true;
        }
        String temp = currPosition + "," + prevJumpStep;
        if (map.containsKey(temp)) {
            return map.get(temp);
        }
        boolean res;
        res = dfs(currPosition + prevJumpStep - 1, prevJumpStep - 1) || 
              dfs(currPosition + prevJumpStep, prevJumpStep) ||
              dfs(currPosition + prevJumpStep + 1, prevJumpStep + 1);
        map.put(temp, res);
        return res;
    }
}
/*
5,3
5,2
*/
