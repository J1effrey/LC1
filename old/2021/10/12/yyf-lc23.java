/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
 10  0 5 | 6 10      0 2|3 5    0 1|2   0 | 1 
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        
        return mergeHelper(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoList(left, right);
    }
    
    private ListNode mergeTwoList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (left != null && right != null) {
            if (left.val > right.val) {
                current.next = right;
                right = right.next;
            } else {
                current.next = left;
                left = left.next;
            }
            current = current.next;
        }
        
        if (left == null) {
            current.next = right;
        } else {
            current.next = left;
        }
        
        return dummy.next;
    }
}
