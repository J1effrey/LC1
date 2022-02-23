// T:O(N)
// S:O(1)
class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return isPalindrome(s, l, r - 1) || isPalindrome(s, l + 1, r);
            }
        }
        return true;
    }
    
    public boolean isPalindrome(String s, int l, int r) {
        if (l > r) {
            return false;
        }
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

/*
abca

*/
