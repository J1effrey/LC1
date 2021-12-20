class Solution {
    // O(MN)  M is length of longest string , N is length of input strings
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = getKey(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
    
    public String getKey(String s) {
        char[] chars = s.toCharArray();
        String key = "";
        for (int i = 1; i < chars.length; i++) {
            int diff = chars[i] - chars[i - 1];
            key += diff < 0 ? diff + 26 : diff;
            key += ",";
        }
        return key;
    }
}

/*
az 0 25 
ba 0 -1+26 = 0 25

abc 0 1 2
zab 0 1 2

acd 0 2 3
*/
