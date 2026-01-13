class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        var wordSet = new HashSet<String>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        var q = new ArrayDeque<String>();
        var visited = new HashSet<String>();

        q.offer(beginWord);
        visited.add(beginWord);
        int step = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; ++i) {
                String curWord = q.poll();
                if (curWord.equals(endWord)) {
                    return step;
                }
                char[] chars = curWord.toCharArray();
                for (int j = 0; j < curWord.length(); j++) {
                    char originChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originChar) {
                            continue;
                        }
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    chars[j] = originChar;
                }
            }
            step++;
        }

        return 0;
    }
}
