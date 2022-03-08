// O(N) N : string length
// O(1)
class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            
            return isPanlindrome(s, left + 1, right) || isPanlindrome(s, left, right - 1);
        }
        
        return true;
    }
    
    private boolean isPanlindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            return false;
        }
        
        return true;
    }
}
