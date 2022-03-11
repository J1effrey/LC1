class Solution {
    public String alienOrder(String[] words) {
        int[] inDegree = new int[26];
        List<Integer>[] edges = new List[26];
        Set<Character> set = new HashSet<>();
        for (String word : words) {
            for (int j = 0; j <word.length(); j++) {
                set.add(word.charAt(j));
            }
        }
        
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].length() > words[i + 1].length() && words[i].startsWith(words[i + 1])) {
                return "";
            }
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    edges[words[i].charAt(j) - 'a'].add(words[i + 1].charAt(j) - 'a');
                    inDegree[words[i + 1].charAt(j) - 'a']++;
                    break;
                }
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0 && set.contains((char)('a' + i))) {
                queue.offer(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append((char)('a' + current));
            for (int i = 0; i < edges[current].size(); i++) {
                int index = edges[current].get(i);
                inDegree[index]--;
                if (inDegree[index] == 0) {
                    queue.offer(index);
                }
            }
        }
        
        if (sb.length() != set.size()) {
            return "";
        }
        
        return sb.toString();
    }
}
