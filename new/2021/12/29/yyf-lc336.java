// time complexity: O(k^2*n)
// space complexity O((k+n)^2)
class Solution {
    class TrieNode {
        TrieNode[] children;
        int wordIndex;
        List<Integer> resIsPalindrome;
        public TrieNode() {
            children = new TrieNode[26];
            wordIndex = -1;
            resIsPalindrome = new ArrayList<>();
        }
    }
    
    List<List<Integer>> res = new ArrayList<>();
    int n;
    TrieNode root = new TrieNode();
    public List<List<Integer>> palindromePairs(String[] words) {
        n = words.length;
        // O(Nk^2)
        for (int i = 0; i < n; i++) {
            add(words[i], i);
        }
        
        for (int i = 0; i < n; i++) {
            search(words[i], i);
        }
        
        return res;
    }
    
    /*
    abcd dcba
    dcba abcd
    xyzll zyx
    xyz llzyx
    aaaa
    */
    public void search(String word, int wordIndex) {
        char[] chs = word.toCharArray();
        TrieNode curr = root;
        for (int i = 0; i < chs.length; i++) {
            int j = chs[i] - 'a';
            //  xyzll   zyx
            if (curr.wordIndex != -1 && isPalindrome(chs, i, chs.length - 1)) {
                res.add(Arrays.asList(wordIndex, curr.wordIndex));
            }
            if (curr.children[j] == null) {
                return;
            }
            curr = curr.children[j];
        }
        // abcd dcba
        if (curr.wordIndex != -1 && wordIndex != curr.wordIndex) {
            res.add(Arrays.asList(wordIndex, curr.wordIndex));
        }
        // xyz  llzyx
        for (int i : curr.resIsPalindrome) {
            res.add(Arrays.asList(wordIndex, i));
        }
        
    }
    
    public void add(String word, int wordIndex) {
        char[] chs = word.toCharArray();
        TrieNode curr = root;
        for (int i = chs.length - 1; i >= 0 ; i--) {
            int j = chs[i] - 'a';
            if (isPalindrome(chs, 0, i)) {
                curr.resIsPalindrome.add(wordIndex);
            }
            if (curr.children[j] == null) {
                curr.children[j] = new TrieNode();
            }
            curr = curr.children[j];
        }
        curr.wordIndex = wordIndex;
    }
    
    public boolean isPalindrome(char[] chs, int i, int j) {
        while (i < j) {
            if (chs[i++] != chs[j--]) {
                return false;
            }
        }
        return true;
    }
}

/*
abcd dcba
dcba abcd
xyzll zyx
xyz llzyx

[xyz,zyx]


xyz 
llzyx 2  z -> [2,3,4]
lllzyx 3 
llllzyx 4
*/
