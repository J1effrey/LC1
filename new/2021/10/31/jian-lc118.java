class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return res;
        }
        
        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        res.add(first);
        
        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1); 
            for (int j = 1; j < i - 1; j++) {
                List<Integer> topLayer = res.get(i - 2);
                int topLeft = topLayer.get(j - 1);
                int topRight = topLayer.get(j);
                row.add(topLeft + topRight);
            }
            row.add(1); 
            res.add(row);
        }
        
        return res;
    }
}
