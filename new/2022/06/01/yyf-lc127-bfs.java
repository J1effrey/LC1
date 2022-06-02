// ToDo: Word Ladder
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;
        int N = beginWord.length();
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String curr = q.poll();
                if (curr.equals(endWord)) {
                    return step;
                }
                for (int j = 0; j < N; j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        StringBuilder sb = new StringBuilder(curr);
                        sb.setCharAt(j, c);
                        String nextWord = sb.toString();
                        if (set.contains(nextWord)) {
                            // early termination 
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }
                            set.remove(nextWord);
                            q.offer(nextWord);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
