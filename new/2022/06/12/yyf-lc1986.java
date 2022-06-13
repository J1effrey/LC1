class Solution {
    int res;
    int maxSessionTime;
    int[] tasks;
    int[] sessions;
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks); // 剪枝，从大到小
        this.res = tasks.length;
        this.maxSessionTime = sessionTime;
        this.tasks = tasks;
        this.sessions = new int[tasks.length];
        dfs(tasks.length - 1, 0);
        return res;
    }
    
    public void dfs(int taskID, int sessionCount) {
        if (sessionCount > res) {
            return;
        }
        if (taskID < 0) {
            res = Math.min(res, sessionCount);
            return;
        }
        for (int i = 0; i < sessionCount; i++) {
            if (sessions[i] + tasks[taskID] <= maxSessionTime) {
                sessions[i] += tasks[taskID];
                dfs(taskID - 1, sessionCount);
                sessions[i] -= tasks[taskID];
            }
            
        }
        sessions[sessionCount] += tasks[taskID];
        dfs(taskID - 1, sessionCount + 1);
        sessions[sessionCount] -= tasks[taskID];
    }
}
