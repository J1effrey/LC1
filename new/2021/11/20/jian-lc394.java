/*
Time: O(maxK*n) k[string]
Space: O(m+n) O(m+n), where mm is the number of letters(a-z) and nn is the number of digits(0-9) in string ss. 
In worst case, the maximum size of stringStack and countStack could be mm and nn respectively.
*/
class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        Stack<Integer> count = new Stack<Integer>();
        Stack<String> strs = new Stack<String>();
        int num = 0;
        StringBuilder temp = new StringBuilder();
      
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (Character.isAlphabetic(c)) {
                temp.append(c);
            } else if (c == '[') {
                count.push(num);
                num = 0;
                strs.push(temp.toString());
                temp = new StringBuilder();
            } else if (c == ']') {
                int repeatTimes = count.pop();
                String curS = temp.toString();
                for (int j = 0; j < repeatTimes - 1; j++) {
                    temp.append(curS);
                }
                temp.insert(0, strs.pop());
            }
        }
        
        return temp.toString();
    }
}
