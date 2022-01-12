// 九章memorization
// T:O()
// S:O()
public class Solution {
    /**
     * @param n: a integer
     * @return: return a 2D array
     */
    public List<List<Integer>> getFactors(int n) {
        // write your code here
        // memorialization
        if (n <= 0) {
            return new ArrayList<List<Integer>>();
        }

        Map<Integer, List<List<Integer>>> memo = new HashMap<>();
        dfs(memo, n,2);
        if (memo.get(n).size() > 0) {
            memo.get(n).remove(memo.get(n).size() - 1);
        }
        return memo.get(n);
    }

    private void dfs(Map<Integer, List<List<Integer>>> memo, int n, int from) {
        // if (memo.containsKey(n)) {
        //     return;
        // }
        memo.put(n, new ArrayList<List<Integer>>());
        for (int i = from; i * i <= n; i++) {
            if (n % i == 0) {
                List<Integer> cur = new ArrayList<>();
                cur.add(i);
                int rest = n / i;
                dfs(memo, rest, i);
                if (memo.containsKey(rest) && memo.get(rest).size() > 0) {
                    for (List<Integer> list : memo.get(rest)) {
                        List<Integer> next = new ArrayList<>(cur);
                        next.addAll(list);
                        memo.get(n).add(next);
                    }
                }
            }
        }
        List<Integer> self = new ArrayList<>();
        self.add(n);
        memo.get(n).add(self);
    }
}

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(n, 2, new ArrayList<>(), res);
        return res;
    }
    
    public void backTrack(int n, int start, List<Integer> temp, List<List<Integer>> res) {
        if (n == 1) {
            if (temp.size() > 1) {
                res.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        
        
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                temp.add(i);
                backTrack(n / i, i, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
