package LinkedList;
/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the
linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]


Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
*/

//Two pointer Time O(N) since only have 2 pointers, and both pointers will traverse the array at most once. Space O(1)
public class LC83RemoveDuplicatesFromSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            // skip the duplicates
            if(fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast= fast.next;
        }
        // delete the following duplicates
        slow.next = null;
        return head;
    }
}
