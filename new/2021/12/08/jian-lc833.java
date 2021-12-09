class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        if (indices == null || indices.length == 0) {
            return s;
        }
        
        if (sources == null || sources.length == 0) {
            return s;
        }
        
        if (targets == null || targets.length == 0) {
            return s;
        }
        
        Map<Integer, String[]> m = new HashMap<>();
        
        for (int i = 0; i < indices.length; i++) {
            int position = indices[i];
            String sourceStr = sources[i];
            String targetStr = targets[i];
            
            if (s.substring(position, position + sourceStr.length()).equals(sourceStr)) {
                m.put(position, new String[]{sourceStr, targetStr});
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (!m.containsKey(i)) {
                sb.append(s.charAt(i));
                i++;
            } else {
                String[] sourceAndTarget = m.get(i);
                String sourceStr = sourceAndTarget[0];
                String targetStr = sourceAndTarget[1];
                sb.append(targetStr);
                i += sourceStr.length();
            }
        }
        
        return sb.toString();
    }
}
