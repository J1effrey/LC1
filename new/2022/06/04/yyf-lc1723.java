// T:O(N!)
class Solution {
    int res = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        dfs(jobs, jobs.length - 1, new int[k]);
        return res;
    }
    
    public void dfs(int[] jobs, int pos, int[] sum) {
        if (pos < 0) {
            res = Math.min(res, Arrays.stream(sum).max().getAsInt());
            return;
        }
        if (Arrays.stream(sum).max().getAsInt() >= res) {
            return;
        }
        for (int i = 0; i < sum.length; i++) {
            if (i > 0 && sum[i] == sum[i - 1]) {
                continue;
            }
            sum[i] += jobs[pos];
            dfs(jobs, pos - 1, sum);
            sum[i] -= jobs[pos];
        }
    }
}
