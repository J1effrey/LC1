// T:O(N^3)
// S:O(N^2) ?
class Solution {
    int target;
    Map<String, Boolean> finishedJumps = new HashMap<>();
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }
        target = stones[stones.length - 1];
        Set<Integer> stonesAvaliable = new HashSet<>();
        for (int stone : stones) {
            stonesAvaliable.add(stone);
        }
        return dfs(1, 1, stonesAvaliable);
    }
    
    public boolean dfs(int position, int lastStep, Set<Integer> stonesAvaliable) {
        if (position == target) {
            return true;
        }
        if (!stonesAvaliable.contains(position)) {
            return false;
        }
        if (lastStep == 0) {
            return false;
        }
        String currentJumpToFinish = position + "," + lastStep;
        if (finishedJumps.containsKey(currentJumpToFinish)) {
            return finishedJumps.get(currentJumpToFinish);
        }
        boolean res = dfs(position + lastStep - 1, lastStep - 1, stonesAvaliable) ||
               dfs(position + lastStep, lastStep, stonesAvaliable) ||
               dfs(position + lastStep + 1, lastStep + 1, stonesAvaliable);
        finishedJumps.put(currentJumpToFinish, res);
        return res;
    }
}

/*
5,3
5,2
*/
