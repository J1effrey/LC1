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
        // O(NK)
        Map<String, Integer> emailParentIndexes = new HashMap<>();
        
        // O(NK)
        for (int i = 0; i < accounts.size(); i++) { // O(N), Here NN is the number of accounts
            for (int j = 1; j < accounts.get(i).size(); j++) { // O(K), K is the maximum length of an account
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
        
        for (int i = 0; i < accounts.size(); i++) {  // O(N)
            int parentIndex = uf.find(i);
            
            if (!mergedAccounts.containsKey(parentIndex)) {
                mergedAccounts.put(parentIndex, new HashSet<>());
            }
            
            Set<String> currentAccounts = mergedAccounts.get(parentIndex);
            
            for (int j = 1; j < accounts.get(i).size(); j++) { // O(K)
                currentAccounts.add(accounts.get(i).get(j));
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        
        // O(NK logNK)
        for (int accountIndex: mergedAccounts.keySet()) { // O(N)
            List<String> emails = new ArrayList<>();
            emails.addAll(mergedAccounts.get(accountIndex));
            Collections.sort(emails); // log(NK)
            emails.add(0, accounts.get(accountIndex).get(0)); // O(K)
            res.add(emails);
        }
        
        return res;
        
    }
}
