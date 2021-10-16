class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> sorted = set.stream().sorted().collect(Collectors.toList());
        Map<Integer, Integer> ranks = new HashMap<>();
        int index = 0;
        for (int sort_num : sorted) {
            ranks.put(sort_num, ++index);
        }
        
        int size = set.size() + 1;
        int[] tree = new int[size];
        for (int i = nums.length - 1; i>= 0; i--) {
            int rank = ranks.get(nums[i]);
            int smaller = query(rank - 1, tree);
            result.add(smaller);
            update(rank, tree, size);
        }
        
        Collections.reverse(result);
        return result;
    }
    
    private int query(int index, int[] tree) {
        int sum = 0;
        while (index >= 1) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }
    
    private void update(int index, int[] tree, int size) {
        while (index < size) {
            tree[index]++;
            index += index & -index;  
        }
    }
}
