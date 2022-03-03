// T: O(N)  
// No extra space complexity
/*
1,2,3,3,3

i = 2  1*1/2*2/3
i = 3  1/2*2/3
i = 4  1/3
*/
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

