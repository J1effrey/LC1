class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        return prev;
        
        
    }
}

---------------------------------------------
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
