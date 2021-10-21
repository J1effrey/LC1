class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                count++;
                candidate = num;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}

/*
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int count = counts.getOrDefault(num, 0) + 1;
            counts.put(num, count);
        }
        Iterator iter = counts.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            if ((int)val > nums.length / 2) {
                return (int)key;
            }
        }
        
        return 0;
    }
}

*/
