class Solution {
    Random random;
    int[] arr;
    public Solution(int[] nums) {
        random = new Random();
        arr = nums;
    }
    
    public int pick(int target) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                count++;
                if (random.nextInt(count) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

/*
class Solution {
    Random random;
    Map<Integer, List<Integer>> map = new HashMap<>();
    public Solution(int[] nums) {
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> list = map.getOrDefault(num, new ArrayList<>());
            list.add(i);
            map.put(num, list);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.getOrDefault(target, new ArrayList<>());
        return list.get(random.nextInt(list.size()));
    }
}
*/
