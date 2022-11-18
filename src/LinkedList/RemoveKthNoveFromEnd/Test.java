package LinkedList.RemoveKthNoveFromEnd;

import LinkedList.LinkedList;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test {
    @org.junit.jupiter.api.Test
    public void TestCase() {
        TestLinkedList test = new TestLinkedList(0);
        test.addNodesFromArray(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] output = new int[] {0, 1, 2, 3, 4, 5, 7, 8, 9};
        RemoveKthNodeFromEnd.removeKthNodeFromEnd(test, 4);
        assertTrue(compare(test.getNodesInArray(), output));
    }

    private boolean compare(List<Integer> nodesArray, int[] output) {
        if(nodesArray.size() != output.length) {
            return false;
        }
        for(int i = 0; i < nodesArray.size(); i++){
            if(!nodesArray.get(i).equals(output[i])){
                return false;
            }
        }
        return true;
    }

    // innerclass
    private class TestLinkedList extends LinkedList {
        public TestLinkedList(int value) {
            super(value);
        }
        public void addNodesFromArray(int[] values) {
            LinkedList inputHead = this;
            while(inputHead.next != null){
                inputHead = inputHead.next;
            }
            for(int value : values) {
                inputHead.next= new LinkedList(value);
                inputHead = inputHead.next;
            }
        }

        public List<Integer> getNodesInArray() {
            LinkedList inputHead = this;
            List<Integer> nodeList = new ArrayList<>();
            while(inputHead != null){
                nodeList.add(inputHead.value);
                inputHead = inputHead.next;
            }
            return nodeList;
        }

    }

}
