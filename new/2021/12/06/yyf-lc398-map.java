// T:O(1)
// S:O(N)
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
