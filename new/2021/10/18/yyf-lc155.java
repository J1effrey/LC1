// O(1)
// O(n)
class MinStack {
    
    Stack<Integer> stack = new Stack<>();
    public int min = Integer.MAX_VALUE;
    
    public MinStack() {
        
    }
    
    public void push(int val) {
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

------------------------------------------------------------------------------------
class MinStack {
    class MinStackElement {
        int val;
        int curMin;
        public MinStackElement(int val, int curMin) {
            this.val = val;
            this.curMin = curMin;
        }
    }
    
    Stack<MinStackElement> s;

    public MinStack() {
        s = new Stack<MinStackElement>();
    }
    
    public void push(int val) {
        int curMin = (s.isEmpty() || val < s.peek().curMin) ? val : s.peek().curMin;
        MinStackElement e = new MinStackElement(val, curMin);
        s.push(e);
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().val;
    }
    
    public int getMin() {
        return s.peek().curMin;
    }
}


---------------------------------------------------------------------------------
class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    
    
    public MinStack() { }
    
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    
    
    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    
    
    public int top() {
        return stack.peek();
    }

    
    public int getMin() {
        return minStack.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
