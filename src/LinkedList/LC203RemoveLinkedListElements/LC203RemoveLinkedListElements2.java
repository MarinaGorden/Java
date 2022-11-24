package LinkedList.LC203RemoveLinkedListElements;

import LinkedList.ListNode;

public class LC203RemoveLinkedListElements2 {
    public ListNode removeElements(ListNode head, int val) {
        while(head.val == val || head != null) head = head.next;
        while(head != null) {
            ListNode curr = head.next;
            while(curr.next != null) {
                if(curr.val == val) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
        }
        return head;
    }
}
