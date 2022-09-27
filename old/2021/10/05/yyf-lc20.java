class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Map<Character, Character> bracketMatch = new HashMap<>();
        bracketMatch.put(')', '(');
        bracketMatch.put(']', '[');  
        bracketMatch.put('}', '{');
        
        Stack<Character> leftBrackets = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!bracketMatch.containsKey(cur)) {
                leftBrackets.push(cur);
                continue;
            }

            if (leftBrackets.isEmpty() || bracketMatch.get(cur) != leftBrackets.pop()) {
                return false;
            }
        }
        
        return leftBrackets.isEmpty();
    }
}
