package LinkedList.FindLinkedListLoop;
import LinkedList.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test {

    @org.junit.jupiter.api.Test
    public void Testcase() {
        TestLinkedList test = new TestLinkedList(0);
        test.addNodes(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        test.getNthNode(10).next = test.getNthNode(5);
        assertTrue(FindLinkedListLoop.findLoop(test) == test.getNthNode(5));
    }

    class TestLinkedList extends LinkedList {
        public TestLinkedList(int value) {
            super(value);
        }
        public void addNodes(int[] values) {
            LinkedList inputHead = this;
            while (inputHead.next != null) {
                inputHead = inputHead.next;
            }
            for (int value : values) {
                inputHead.next= new LinkedList(value);
                inputHead = inputHead.next;
            }
        }

        public LinkedList getNthNode(int n) {
            int counter = 1;
            LinkedList inputHead = this;
            while (counter < n) {
                inputHead = inputHead.next;
                counter++;
            }
            return inputHead;
        }
    }
}
