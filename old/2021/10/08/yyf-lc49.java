class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String sameStr = String.valueOf(ca);
            List<String> list = map.getOrDefault(sameStr, new ArrayList<String>());
            list.add(str);
            map.put(sameStr, list);
        }
        
        return new ArrayList(map.values());
    }
}