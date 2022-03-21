// O(N)
// O(N)
class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        
        if (str1.equals(str2)) {
            return true;
        }
        
        Map<Character, Character> coversions = new HashMap<>();
        
        for (int i = 0; i < str1.length(); i++) {
            char orginal = str1.charAt(i);
            char dest = str2.charAt(i);
            
            if (!coversions.containsKey(orginal)) {
                coversions.put(orginal, dest);
            } 
            
            char curConversion = coversions.get(orginal);
            if (curConversion != dest) {
                return false;
            }
        }
        
        return new HashSet<>(coversions.values()).size() < 26;
    }
}
