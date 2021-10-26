class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode nextOfHead = head.next;
            ListNode nextOfDummy = dummy.next;
            
            dummy.next = head;
            head.next = nextOfDummy;
            
            head = nextOfHead;
        }
        
        
        return dummy.next;
    }
}
