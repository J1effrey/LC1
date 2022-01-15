// T: O(n)
// S: O(n)

public class Solution {
    public int evalRPN(String[] tokens) {
        int a,b;
		Stack<Integer> S = new Stack<Integer>();
		for (String s : tokens) {
			if(s.equals("+")) {
				S.add(S.pop()+S.pop());
			}
			else if(s.equals("/")) {
				b = S.pop();
				a = S.pop();
				S.add(a / b);
			}
			else if(s.equals("*")) {
				S.add(S.pop() * S.pop());
			}
			else if(s.equals("-")) {
				b = S.pop();
				a = S.pop();
				S.add(a - b);
			}
			else {
				S.add(Integer.parseInt(s));
			}
		}	
		return S.pop();
	}
}

====
    
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        for (String s : tokens) {
            if (!set.contains(s)) {
                stack.push(Integer.parseInt(s));
                continue;
            }
            int secondNumber = stack.pop();
            int firstNumber = stack.pop();
            if (s.equals("+")) {
                stack.push(firstNumber + secondNumber);
            } else if (s.equals("-")) {
                stack.push(firstNumber - secondNumber);
            } else if (s.equals("*")) {
                stack.push(firstNumber * secondNumber);
            } else {
                stack.push(firstNumber / secondNumber);
            }
        }
        return stack.pop();
    }
}

/*
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            switch(s) {
                case "+" :
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-" :
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*" :
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int after = stack.pop();
                    int before = stack.pop();
                    stack.push(before / after);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
*/
