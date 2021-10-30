/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        ListNode l = l1;
        ListNode r = l2;
        while (l != null || r!=null) {
            int lVal = l == null ? 0 : l.val;
            int rVal = r == null ? 0 : r.val;
            int sum = lVal + rVal + carry;
            carry = sum / 10;
            int val = sum % 10;
            current.next = new ListNode(val);
            current = current.next;
            if (l != null) {
                l = l.next;
            }
            if (r != null) {
                r = r.next;
            }
        }
        
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}