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