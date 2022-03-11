// O(Nlogk)
// O(N+k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode();
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode head = dummy;
        for (ListNode list: lists) {
            if (list == null) {
                continue;
            }
            pq.offer(list);
        }
        
        while (!pq.isEmpty()) {
            head.next = pq.poll();
            head = head.next; // curr
            if (head.next != null) {
                pq.offer(head.next);
            }
        }
        return dummy.next;
    }
}
