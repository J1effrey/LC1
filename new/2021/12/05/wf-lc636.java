class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || logs.size() == 0 || n == 0) {
            return new int[0];
        }
        
        Stack<Integer> stack = new Stack<>();
        int lastTimeStamp = 0;
        int[] res = new int[n];
        
        for (String log: logs) {
            String[] strings = log.split(":");
            int id = Integer.parseInt(strings[0]);
            int time = Integer.parseInt(strings[2]);
            String flag = strings[1];
            
            if (!stack.isEmpty()) {
                int tempId = stack.peek();
                res[tempId] += time - lastTimeStamp;
            }
            
            if (flag.equals("start")) {
                stack.push(id);
            } else {
                int tempId = stack.peek();
                res[tempId]++;
                time++;
                stack.pop();
            }
            
            lastTimeStamp = time;
        }
        return res;
    }
}
