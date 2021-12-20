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
/*
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || logs.size() == 0 || n == 0) {
            return new int[]{};
        }
        
        Stack<Integer> stack = new Stack<>();
        int lastTimeStamp = 0;
        int[] res = new int[n];
        
        for (String log: logs) {
            String[] arr = log.split(":");
            int id = Integer.parseInt(arr[0]);
            String flag = arr[1];
            int time = Integer.parseInt(arr[2]);;
            
            if (!stack.isEmpty()) {
                res[stack.peek()] += (time - lastTimeStamp);
            }
            
            if (flag.equals("start")) {
                stack.push(id);
            } else {
                time++;
                res[stack.peek()]++;
                stack.pop();
            }
            lastTimeStamp = time;
        }
        return res;
    }
}
*/
