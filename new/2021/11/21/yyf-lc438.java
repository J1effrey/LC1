// T: O(N) N : s length
// S: O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return res;
        }
        
        int m = s.length();
        int n = p.length();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        
        for (char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }
        
        int right = 0;
        int left = 0;
        while (right < m) {
            sCount[s.charAt(right) - 'a']++;
            
            if (right - left + 1 == n) {
                if (Arrays.equals(pCount, sCount)) {
                    res.add(right - n + 1);
                }
                sCount[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        
        return res;
    }
}

===
    
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return res;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        int sLen = s.length();
        int pLen = p.length();
        for (char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }
        
        for (int i = 0; i < sLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            if (i >= pLen) {
                sCount[s.charAt(i - pLen) - 'a']--;
            }
            if (Arrays.equals(sCount, pCount)) {
                res.add(i - pLen + 1);
            }
        }
        return res;
    }
}
