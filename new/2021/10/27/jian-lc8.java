class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0 || s.trim().equals("")) {
            return 0;
        }
        
        s = s.trim();
        int sign = 1;
        int index = 0;
        int num = 0;
        
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            if (s.charAt(index) == '-') {
                sign = -1;
            }
            index++;
        }
        
        int bound = Integer.MAX_VALUE / 10;
        int lastDigit = Integer.MAX_VALUE % 10;
        
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int curVal = s.charAt(index) - '0';
            
            if (num >= Integer.MAX_VALUE || num > bound || (num == bound && curVal > lastDigit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            num = num * 10 + curVal;
            index++;
        }
        
        return sign * num;
    }
}
