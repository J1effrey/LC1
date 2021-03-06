//Time:O(N*M) n:words.length m:最长的单词长度
//Space:O(1) = O(26)
class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }   
        
        // caculate the edge and indegree
        Map<Character, Integer> indegree = new HashMap<Character, Integer>();
        Map<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();

        for (String word: words) { // O(n)
            for (int i = 0; i < word.length(); i++) { //O(m) m:最长的单词长度
                indegree.putIfAbsent(word.charAt(i), 0);
                graph.putIfAbsent(word.charAt(i), new HashSet<Character>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) { //O(n)
            String first = words[i];
            String second = words[i + 1];
            int j = 0;
            
            while (j < first.length() && j < second.length() && first.charAt(j) == second.charAt(j)) { //O(m) m:最长的单词长度
                j++; 
            }
            
            if (j < first.length() && j < second.length()) {
                char source = first.charAt(j);
                char destination = second.charAt(j);
                
                // add edge
                Set<Character> neighbours = graph.get(source);
                if (!neighbours.contains(destination)) {
                    neighbours.add(destination);
                    indegree.put(destination, indegree.get(destination) + 1);
                }
            } else if (j == second.length() && j < first.length()) {
                return "";
            }  
        }
        
        int uniqueChar = indegree.size();
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<Character>();
        
        for (Character c : indegree.keySet()) { //O(1) = O(26)
            if (indegree.get(c) == 0) {
                q.offer(c);
            }
        }
             
        while (!q.isEmpty()) { //O(1) = O(26)
            char cur = q.poll();
            sb.append(cur);
            Set<Character> neighbours = graph.get(cur);
            for (char n : neighbours) {
                int indegreeOfN = indegree.get(n);
                indegreeOfN--;
                indegree.put(n, indegreeOfN);
                if (indegreeOfN == 0) {
                    q.offer(n);
                }
            }
        }
        
        return sb.length() == uniqueChar ? sb.toString() : "";
    }
}
