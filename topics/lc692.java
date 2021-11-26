class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || k == 0) {
            return res;
        }
        
        // O(n) hashing
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.merge(word, 1, Integer::sum);
        }
        String[] wordSet = counts.keySet().toArray(new String[0]);
        
        // most frequent -> least frequent, then alphabetical order
        Comparator<String> comp = Comparator
            .comparing((String w) -> -counts.get(w)) 
            .thenComparing(Comparator.naturalOrder());
            
        // O(n) quick select
        quickSelect(wordSet, comp, 0, wordSet.length - 1, k - 1); 
        Arrays.sort(wordSet, 0, k - 1, comp);  // O(klogk) sort
        
        return Arrays.asList(Arrays.copyOf(wordSet, k)); 
    }
    
    // Quick select with custom Comparator
    private String quickSelect(String[] words,  
                               Comparator<String> comp,
                               int start, 
                               int end, 
                               int k) {
        if (start >= end) {
            return words[k];
        }
        
        String pivot = words[start + (end - start) / 2];
        int left = start, right = end; 
        while (left <= right) {
            while (left <= right && comp.compare(words[left], pivot) < 0) {
                left++;
            }
            
            while (left <= right && comp.compare(words[right], pivot) > 0) {
                right--;
            }
            
            if (left <= right) {
                String temp = words[left];
                words[left++] = words[right];
                words[right--] = temp;
            }
        }
        
        if (k <= right) {
            return quickSelect(words, comp, start, right, k);
        }
        
        if (k >= left) {
            return quickSelect(words, comp, left, end, k);
        }
        
        return words[k];
    }
}