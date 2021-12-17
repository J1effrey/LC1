class Solution {
    static class Log {
        public int id;
        public boolean isStart;
        public int time;
        
        public Log(String content) {
            String[] strs = content.split(":");
            id = Integer.valueOf(strs[0]);
            isStart = strs[1].equals("start");
            time = Integer.valueOf(strs[2]);
        }
    }
    
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        
        if (logs == null || logs.size() == 0) {
            return result;
        }
        
        Stack<Log> stack = new Stack<>();
        
        for (String content : logs) {
            Log log = new Log(content);
            if (log.isStart) {
                stack.push(log);
            } else {
                Log top = stack.pop();
                result[top.id] += (log.time - top.time + 1);
                if (!stack.isEmpty()) {
                    // very good
                    result[stack.peek().id] -= (log.time - top.time + 1);
                }
            }
        }
        
        return result;
    }
}
