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
