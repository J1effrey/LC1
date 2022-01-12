// T: O(n)
// S: O(n)
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);

        int levelSum = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                NestedInteger nested = queue.poll();

                if (nested.isInteger()) {
                    levelSum += nested.getInteger();
                 } else {
                    for (NestedInteger n: nested.getList()) {
                         queue.offer(n);
                    }
                }
            }

            result += levelSum;
        }

        return result;
    }
}
