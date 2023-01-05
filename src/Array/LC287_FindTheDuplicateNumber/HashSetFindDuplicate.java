package Array.LC287_FindTheDuplicateNumber;

import java.util.*;

// Set Time O(N) | Space O(N)
public class HashSetFindDuplicate {
    public int findDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num)) return num;
            visited.add(num);
        }
        // edge case couldn't find
        return -1;
    }
}
