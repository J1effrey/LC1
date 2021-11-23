class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        
        ListNode start = head;
        ListNode end = head;
        
        for (int i = 0; i < k; i++) {
            if (end == null) {
                return head;
            }
            end = end.next;
        }
        
        ListNode newHead = reverse(start, end);
        start.next = reverseKGroup(end, k);
        
        return newHead;
    }
    
    private ListNode reverse(ListNode start, ListNode end) {
        // end is not included
        ListNode dummy = new ListNode();
        
        while (start != end) {
            ListNode dummyNext = dummy.next;
            ListNode startNext = start.next;
            
            dummy.next = start;
            start.next = dummyNext;
            
            start = startNext;
        }
        
        return dummy.next;
    }
}
