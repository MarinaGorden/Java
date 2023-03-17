package LinkedList.LC24_SwapNodesInPairs;

import LinkedList.ListNode;

public class LC24_SwapNodesInPairs2 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        while (head != null && head.next != null) {
            ListNode slow = head, fast = head.next;
            prev.next = fast;
            slow.next = fast.next;
            fast.next = slow;
            // reinitialize the head and prev(tmp)
            prev = slow;
            // jump to the next half 3 -> 4
            dummyHead = slow.next;
        }
        return dummyHead.next;
    }
}
