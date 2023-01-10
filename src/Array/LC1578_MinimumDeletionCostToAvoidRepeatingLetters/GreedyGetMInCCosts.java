package Array.LC1578_MinimumDeletionCostToAvoidRepeatingLetters;
// Greedy Time O(N) | Space O(1)
public class GreedyGetMInCCosts {
    public int minCost(String s,int[] cost) {
        char[] charArray = s.toCharArray();
        int sum = 0, prev = 0;
        char prevChar = '?';
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if(c == prevChar) {
                sum = Math.min(prev, cost[i]);
                prev = Math.max(prev, cost[i]);
            } else{
                prevChar = c;
                prev = cost[i];
            }
        }
        return sum;
    }
}
