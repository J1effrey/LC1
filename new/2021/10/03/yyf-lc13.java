class Solution {
    static Map<Character, Integer> map = new HashMap<>();
    
    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int res = 0;
        int value = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= value) {
                res += map.get(s.charAt(i));
            } else {
                res -= map.get(s.charAt(i));
            }
            value = map.get(s.charAt(i));
        }
        
        return res;
        
    }
}

------------------------
class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int length = s.length();
        int res = map.get(s.charAt(length - 1));
        
        for (int i = length - 2; i >= 0; i--) {
            if (map.get(s.charAt(i + 1)) <= map.get(s.charAt(i))) {
                res += map.get(s.charAt(i));
            } else {
                res -= map.get(s.charAt(i));
            }
        }
        return res;
    }
}
