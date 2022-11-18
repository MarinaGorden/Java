package LinkedList.RemoveKthNoveFromEnd;

import LinkedList.LinkedList;

/*
Given the head pointer of the singly linked list and the value of a node to be deleted, define a function to
delete the node.
Returns the head node of the deleted linked list.

Example 1:
Input: head = [4,5,1,9], val = 5
Output: [4,1,9]
Explanation: Given the second node in your linked list with value 5, then after calling your function, the linked list
 should become 4 -> 1 -> 9.

Example 2:
Input: head = [4,5,1,9], val = 1
Output: [4,5,9]
Explanation: Given the third node in your linked list with value 1, then after calling your function, the linked list
 should become 4 -> 5 -> 9.
 */
public class RemoveKthNodeFromEnd {
    // Two pointer Time O(N) | Space O(1)
   public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList slow = head, fast = head;
        // Notice: the LinkedList already has the head so size = 1
        // Let the fast pointer go k step ahead
        for(int size = 1; size <= k; size++) {
            fast = fast.next;
        }
        // edge case: k=LinkedList.size, delete the head(node need to remove)
        if(fast == null) {
            head.value = head.next.value;
            head.next = head.next.next;
            // skip the following process
            return;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
    }
}
