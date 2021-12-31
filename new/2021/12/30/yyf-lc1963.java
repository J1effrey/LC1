// Time: O(N)
// Space: O(1)
class Solution {
    public int minSwaps(String s) {
        int stack_size = 0;
        for (int i = 0; i < s.length (); i++) {
            char ch = s.charAt (i);
            if (ch == '[')
                stack_size++;
            else {
                if (stack_size > 0)
                    stack_size--;
            }
        }
        // ]]][[[ 如果有n对不平衡的括号，只需要(n+1)/2次交换就能使其平衡 
        // 两端括号交换 搞定两对
        return (stack_size + 1) / 2;
    }
}
