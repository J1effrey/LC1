class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
       var bankSet = new HashSet<>(Arrays.asList(bank));

        if (!bankSet.contains(endGene)) {
            return -1;
        }

        char[] AGCT = {'A', 'G', 'C', 'T'};

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(startGene);
        visited.add(startGene);

        int step = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int j = 0; j < sz; j++) {
                String cur = q.poll();

                if (cur.equals(endGene)) {
                    return step;
                }
                

                for (String newGene : getAllMutation(cur)) {
                    if (!visited.contains(newGene) && bankSet.contains(newGene)) {
                        q.offer(newGene);
                        visited.add(newGene);
                    }
                }
            }
            step++;
        }
        
        return -1;
    }

    private List<String> getAllMutation(String gene) {
        List<String> res = new ArrayList<>();
        char[] geneChars = gene.toCharArray();
        for (int i = 0; i < geneChars.length; i++) {
            char oldChar = geneChars[i];
            for (char newChar : new char[]{'A', 'G', 'C', 'T'}) {
                geneChars[i] = newChar;
                res.add(new String(geneChars));
            }
            geneChars[i] = oldChar;
        }
        return res;
    }
}
