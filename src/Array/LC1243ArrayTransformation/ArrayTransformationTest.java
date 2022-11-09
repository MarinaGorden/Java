package Array.LC1243ArrayTransformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayTransformationTest {
    @org.junit.jupiter.api.Test
    public void testCase(){

        int[][] expectedList= {
                {1,4,4,4,4,5},
                {2,2,1,1,1,2,2,1},
                {1,4,5,7,7,3,4,2,2,5,8,8,6,5,4,4,4,3}
        };
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        for(int[] array : expectedList) {
            expected.add(Arrays.stream(array).boxed().collect(Collectors.toCollection(ArrayList::new)));
        }

        int[][] input = {
                {1,6,3,4,3,5},
                {2,1,2,1,1,2,2,1},
                {1,5,4,7,9,2,5,1,2,5,8,8,3,8,4,4,6,3}
        };

        for(int i = 0; i < input.length; i++) {
            assertTrue(ArrayTransformation.transformArray(input[i]), expected.get(i));
        }
    }

    private boolean assertTrue(List<Integer> transformArray, ArrayList<Integer> toArray) {
        if (transformArray.size() != toArray.size()) {
            return false;
        }
        for(int i = 0; i < transformArray.size(); i++) {
            if(!transformArray.get(i).equals(toArray.get(i))) {
                return false;
            }
        }
        return true;
    }
}
