class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int s1 = getSize(l1);
        int s2 = getSize(l2);
        if (s2 > s1) {
            return addTwoNumbers(l2, l1);
        }
        ListNode n = null;
        ListNode resHead = null;
        while (l1 != null || l2 != null) {
            int v1 = l1.val;
            l1 = l1.next;
            int v2 = s1 <= s2 ? l2.val : 0;
            l2 = s1 <= s2 ? l2.next : l2;
            s1--;
            n = new ListNode(v1 + v2);
            n.next = resHead;
            resHead = n;
        }
        
        int carry = 0;
        resHead = null;
        while (n != null) {
            n.val += carry;
            carry = n.val / 10;
            n.val = n.val % 10;
            ListNode temp = n.next;
            n.next = resHead;
            resHead = n;
            n = temp;
        }
        if (carry > 0) {
            n = new ListNode(carry);
            n.next = resHead;
            resHead = n;
        }
        
        return resHead;
        
    }
    
    public int getSize(ListNode l) {
        int size = 0;
        while (l != null) {
            l = l.next;
            size++;
        }
        return size;
    }
}
