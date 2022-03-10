/**
 * Using union-find (Union by rank and path compression) to group all emails
 * belonging to same owner. And using TreeSet to sort each group of emails.
 *
 * Time Complexity: O(N + N * log(N) + N) = O(N * log(N))
 *
 * Space Complexity: O(N)
 *
 * N = Total number of email addresses in the input. Here assuming the length of
 * each email and owner string is a fixed constant.
 */

class UnionFind {
    int[] parents;
    int[] size;
    int count;
    public UnionFind(int n) {
        this.parents = new int[n];
        this.size = new int[n];
        this.count = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        while (x != parents[x]) {
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        } 

        if (size[rootP] > size[rootQ]) {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    public int getCount() {
        return this.count;
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) {
            return new ArrayList<>();
        }
        
        UnionFind uf = new UnionFind(accounts.size());
        
        // only used for union
        Map<String, Integer> emailParentIndexes = new HashMap<>();
        
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!emailParentIndexes.containsKey(email)) {
                    emailParentIndexes.put(email, i);
                    continue;
                } 
                int parentIndexOfEmail = emailParentIndexes.get(email);
                uf.union(parentIndexOfEmail, i);
            }
        }
        
        // aggregate same accounts
        Map<Integer, Set<String>> mergedAccounts = new HashMap<>();
        
        for (int i = 0; i < accounts.size(); i++) {
            int parentIndex = uf.find(i);
            
            if (!mergedAccounts.containsKey(parentIndex)) {
                mergedAccounts.put(parentIndex, new HashSet<>());
            }
            
            Set<String> currentAccounts = mergedAccounts.get(parentIndex);
            
            for (int j = 1; j < accounts.get(i).size(); j++) {
                currentAccounts.add(accounts.get(i).get(j));
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for (int accountIndex: mergedAccounts.keySet()) {
            List<String> emails = new ArrayList<>();
            emails.addAll(mergedAccounts.get(accountIndex));
            Collections.sort(emails);
            emails.add(0, accounts.get(accountIndex).get(0));
            res.add(emails);
        }
        
        return res;
        
    }
}
