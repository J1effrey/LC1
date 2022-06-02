class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordListInput) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> wordList = new HashSet<>(wordListInput);
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int step = 1;
        int N = beginWord.length();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) { // 从beginSet里面每一个word展开，看是否到endSet
                char[] chs = word.toCharArray();
                for (int i = 0; i < N; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char prev = chs[i];
                        chs[i] = c;
                        String nextWord = new String(chs);
                        if (endSet.contains(nextWord)) {
                            return step + 1;
                        }
                        if (wordList.contains(nextWord)) {
                            wordList.remove(nextWord);
                            nextSet.add(nextWord);
                        }
                        chs[i] = prev;
                    }
                }
            }
            if (endSet.size() < nextSet.size()) { // 最核心优化，我们选择较小的一端开始展开
                beginSet = endSet;
                endSet = nextSet;
            } else {
                beginSet = nextSet;
            }
            step++;
        }
        return 0;
        
    }
}
