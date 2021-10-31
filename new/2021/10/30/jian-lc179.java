class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        String[] newNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(newNums, (a, b) -> (b + a).compareTo(a + b));
       
        StringBuilder sb = new StringBuilder();
        
        for (String num : newNums) {
            sb.append(num);
        }
        
        if (sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}
