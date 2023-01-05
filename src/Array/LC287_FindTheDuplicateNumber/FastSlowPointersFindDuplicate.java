package Array.LC287_FindTheDuplicateNumber;
//  Floyd's Tortoise and Hare (Cycle Detection) / Fast Slow pointers Time O(N) | Space O (1)

public class FastSlowPointersFindDuplicate {
    public int findDuplicate(int[] nums) {
        // the same as find linked list loop, treat this array[1,3,4,2,2] as the linked list 0->1->3->2->4->2->...
        int slow = 0, fast = 0;
        // slow moves 1 step, fast moves 2 steps when they meet, find the loop
        while (slow == 0 ||slow !=fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // let another pointer start at the meeting point, if it catches the slow pointer there's the duplicate
        int p = 0;
        while (p != slow) {
            p = nums[p];
            slow = nums[slow];
        }
        return p;
    }
}
