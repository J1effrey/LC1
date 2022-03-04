class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                right++;
                continue;
            } 
            
            if (right > 0) {
                right--;
                continue;
            }
            
            left++;
        }
        return left + right;
    }
}
