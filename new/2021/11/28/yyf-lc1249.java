// T: O(N)
// S: O(N)
class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        Stack<Integer> leftBrackets = new Stack<>();
        char[] sCharArray = s.toCharArray();
        
        for (int i = 0; i < sCharArray.length; i++) {
            char c = sCharArray[i];
            if (c == '(') {
                leftBrackets.push(i);
                continue;
            } 
            
            if (c == ')') {
                if (leftBrackets.isEmpty()) {
                    sCharArray[i] = '.';
                } else {
                    leftBrackets.pop();
                }    
            }
        }
        
        while (!leftBrackets.isEmpty()) {
            sCharArray[leftBrackets.pop()] = '.';
        }
        
        return convertToResult(sCharArray);
        
    }
    
    private String convertToResult(char[] array) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] != '.') {
                sb.append(array[i]);
            }    
        }
        
        return sb.toString();
        
    }
}
