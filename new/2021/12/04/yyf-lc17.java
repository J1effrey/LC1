class Solution {
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private String phoneDigits;
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        
        phoneDigits = digits;
        
        backTrack(0, new StringBuilder());
        return combinations;
        
    }
    
    private void backTrack(int index, StringBuilder path) {
        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return;
        }
        
        char i = phoneDigits.charAt(index);
        String s = letters.get(i);
        for (int j = 0; j < s.length(); j++) {
            path.append(s.charAt(j));
            backTrack(index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}