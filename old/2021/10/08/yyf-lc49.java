class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        var anagrams = new HashMap<String, List<String>>();

        for (String s : strs) {
            String encoded = encode(s);
            anagrams.putIfAbsent(encoded, new ArrayList<String>());
            anagrams.get(encoded).add(s);
        }

        return new ArrayList<>(anagrams.values());
    }

    private String encode(String s) {
        int[] chars = new int[26];

        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            sb.append("#");
            sb.append(chars[i]);
        }

        return sb.toString();
    }
}

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
