class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        int res = 0;
        
        for (NestedInteger node: nestedList) {
            res += getDepthSumOfNode(node, 1);
        }
        
        return res;
        
    }
    
    private int getDepthSumOfNode(NestedInteger node, int curDepth) {
        int depthSum = 0;
        
        if (node.isInteger()) {
            depthSum += curDepth * node.getInteger();
        } else {
            for (NestedInteger child: node.getList()) {
                depthSum += getDepthSumOfNode(child, curDepth + 1);
            }
        }
        
        return depthSum;
    }
}
