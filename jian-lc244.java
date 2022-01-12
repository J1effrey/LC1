// T: O(N)
// S: O(N)

public class WordDistance {
    Map<String, List<Integer>> map = new HashMap<>();
    
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {   
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        
        while(i < list1.size() && j < list2.size()) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            
            if (index1 > index2) {
                min = Math.min(min, index1 - index2);
                j++;
            } else {
                min = Math.min(min, index2 - index1);
                i++;                
            }
        }
        
        return min;
    }
}
