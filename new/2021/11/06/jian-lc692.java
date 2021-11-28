class Solution {
    public List<String> topKFrequent(String[] words, int k) {      
        if (words == null || words.length == 0 || k == 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.merge(word, 1, Integer::sum);
        }
        String[] wordSet = counts.keySet().toArray(new String[0]);
        
        
        Comparator<String> comp = Comparator
            .comparing((String w) -> -counts.get(w)) 
            .thenComparing(Comparator.naturalOrder());
            
        
        quickSelect(wordSet, comp, 0, wordSet.length - 1, k - 1); 
        Arrays.sort(wordSet, 0, k - 1, comp); 
        
        return Arrays.asList(Arrays.copyOf(wordSet, k)); 
    }
    
    private void quickSelect(String[] words, Comparator<String> comp, int start, int end, int k) {
        if (start >= end) {
            return;
        }
        
        String pivot = words[start + (end - start) / 2];
        int left = start;
        int right = end; 
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
            quickSelect(words, comp, start, right, k);
        }
        
        if (k >= left) {
            quickSelect(words, comp, left, end, k);
        }
    }
}
