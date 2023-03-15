package LinkedList.LC24_SwapNodesInPairs;

import LinkedList.ListNode;

/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the
 values in the list's nodes (i.e., only nodes themselves may be changed.)


Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:
Input: head = []
Output: []

Example 3:
Input: head = [1]
Output: [1]


Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
*/
public class LC24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        // edge case: no node || only one node
        if (head == null || head.next == null) return null;
        // 1, 2, 3, 4, slow -> 1,  fast -> 2
        ListNode slow = head, fast = head.next;
        // swap the last half 3, 4 -> 4, 3
        slow.next = swapPairs(fast.next);
        // swap slow and fast node 1, 2, 4, 3 -> 2, 1, 3, 4
        fast.next = slow;
        // fast become the new node
        return fast;
    }
}
