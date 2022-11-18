package LinkedList.FindLinkedListLoop;

import LinkedList.LinkedList;

import java.util.HashSet;
import java.util.Set;

/*
Write a function that takes in the head of a Singly Linked List that contains a loop(in other words, the list's tail
 node points to some nodes in the list instead of None/Null). The function should return the node (
*/
public class FindLinkedListLoop {
    public static LinkedList findLoop(LinkedList head) {
        if (head == null) return null;
        Set<LinkedList> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) break;
            visited.add(head);
            head = head.next;
        }
        return head;
    }

}