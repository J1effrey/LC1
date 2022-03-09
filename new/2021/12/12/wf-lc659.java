// T:O(N)
// S:O(N)
class Solution {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> tail = new HashMap<>();//存已有数列的尾巴+1的值
        
        //Greedy: 
        //1.如果能加入已有数列的尾巴，则加入
        //2.加不进去就新开一个数列
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        
        for (int i : nums) {
            if (freq.get(i) <= 0) {
                continue;
            }
            if (tail.getOrDefault(i, 0) > 0) {
                freq.put(i, freq.get(i) - 1);
                tail.put(i, tail.get(i) - 1);
                tail.put(i + 1, tail.getOrDefault(i + 1, 0) + 1);
                continue;
            }
            
            //新开一个顺子
            if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0){
                freq.put(i, freq.get(i) - 1);
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                tail.put(i + 3, tail.getOrDefault(i + 3, 0) + 1);
                continue;
            }
            
            return false;
        }
        return true;
    }
}
