class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        if (str1.equals(str2)) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (map.containsKey(str1.charAt(i))) {
                char ch = map.get(str1.charAt(i));
                if (ch != str2.charAt(i)) {
                    return false;
                }
            } else {
                map.put(str1.charAt(i), str2.charAt(i));
            }
        }
        
        return new HashSet<>(map.values()).size() < 26;
    }
}

/*


*/
