class Solution {
    /*
    Set<>: [100,4,200,1,3,2]
    
    100: remove Maxlen 1
    4: 1
    3: 1
    3 - 1: 2 1
    2 - 1: 1
    1 - 1: 0 
    
    */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        int res = 0;
        
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                
                int left = num - 1;
                int right = num + 1;
                
                while (set.contains(left)) {
                    set.remove(left);
                    left--;
                }
                
                while (set.contains(right)) {
                    set.remove(right);
                    right++;
                }
                res = Math.max(res, right - left - 1);
            }
        }
        return res;
    }
}