package LinkedList;
import LinkedList.LC83RemoveDuplicatesFromSortedList.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test {
    // Add Nodes to the linked list
    public ListNode addNods(ListNode inputList, List<Integer> inputValue) {
        ListNode node = inputList;
        while (node.next != null) {
            node = node.next;
        }
        for (int value: inputValue) {
            // need set the ListNode class static to make sure the parametrized constructor available
            node.next = new ListNode(value);
            node = node.next;
        }
        return inputList;
    }

    public List<Integer> getNodesInArray(ListNode inputList) {
        List<Integer> nodes = new ArrayList<Integer>();
        ListNode node = inputList;
        while (node != null) {
            nodes.add(node.val);
            node = node.next;
        }
        return nodes;
    }

    @org.junit.jupiter.api.Test
    public void TestCase() {
        ListNode inputHead = new ListNode(1);
        addNods(inputHead, new ArrayList<Integer>(Arrays.asList(1,3,4,4,4,5,6,6)));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1,3,4,5,6));
        ListNode output = new LC83RemoveDuplicatesFromSortedList().deleteDuplicates(inputHead);
        assertTrue(getNodesInArray(output).equals(expected));
        ListNode inputHead2 = new ListNode(-5);
        addNods(inputHead2, new ArrayList<Integer>(Arrays.asList(-5,-1,-1,-1,5,5,8,8,9,10,11,11)));
        ListNode output2 = new LC83RemoveDuplicatesFromSortedList().deleteDuplicates(inputHead2);
        List<Integer> expected2 = new ArrayList<>(Arrays.asList(-5,-1,5,8,9,10,11));
        assertTrue(getNodesInArray(output2).equals(expected2));
    }
}
