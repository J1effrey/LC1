public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;
    private void pushToStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
    
    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            nestedList = new ArrayList<NestedInteger>();
        }
        stack = new Stack<>();
        pushToStack(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushToStack(stack.pop().getList());
        }
        return !stack.isEmpty();
    }
}
