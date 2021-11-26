class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int r = 0;
        int x = 0;
        while (r < chars.length) {
            char currentChar = chars[r];
            int count = 0;
            while (r < chars.length && chars[r] == currentChar) {
                r++;
                count++;
            }
            chars[x++] = currentChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray()) 
                    chars[x++] = c;
        }
        return x;
    }
}
