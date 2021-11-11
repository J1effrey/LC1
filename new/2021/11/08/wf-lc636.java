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
