public class Solution {
    public ListNode detectCycle(ListNode head) {
        /*
            一快一慢一起走
            两针相遇慢回头
            一步走，一步走
            再相遇，就足够
        */
        
        if (head == null) {
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                
                return fast;
            }
        }
        
        return null;
    }
}
