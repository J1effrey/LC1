class Solution {
    private List<String> res = new ArrayList<>();
    private Map<Character, String> letters = Map.of('2', "abc", '3', "def", '4', "ghi", 
                                                   '5', "jkl", '6', "mno", '7', "pqrs", 
                                                   '8', "tuv", '9', "wxyz");
    private String phoneDigits;
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        phoneDigits = digits;
        backTrack(0, new StringBuilder());
        return res;
        
    }
    
    private void backTrack(int index, StringBuilder sb) {
        if (index == phoneDigits.length()) {
            res.add(sb.toString());
            return;
        }
        
        char c = phoneDigits.charAt(index);
        String s = letters.get(c);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backTrack(index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}