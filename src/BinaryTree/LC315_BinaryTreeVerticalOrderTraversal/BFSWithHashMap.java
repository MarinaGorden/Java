package BinaryTree.LC315_BinaryTreeVerticalOrderTraversal;
/*
Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom,
column by column).
If two nodes are in the same row and column, the order should be from left to right.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]

Example 2:
Input: root = [3,9,8,4,0,1,7]
Output: [[4],[9],[3,0,1],[8],[7]]

Example 3:
Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
Output: [[4],[9,5],[3,0,1],[8,2],[7]]

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/

import BinaryTree.TreeNode;
import java.util.*;

public class BFSWithHashMap {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, ArrayList> columnMap = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        int column = 0, min = 0, max = 0;
        queue.offer(new Pair(root, column));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> nodePair = queue.poll();
            root = nodePair.getKey();
            column = nodePair.getValue();

            if (root != null) {
                // the current column hasn't been visited
                if (!columnMap.containsKey(column)) columnMap.put(column, new ArrayList<>());

                // since there are null node in the example shouldn't skip the empty node
                columnMap.get(column).add(root.val);
                // narrow the searching index. Math.min takes longer time to compare!!
                min = Integer.min(min, column);
                max = Integer.max(max, column);
                queue.offer(new Pair(root.left, column - 1));
                queue.offer(new Pair<>(root.right, column + 1));
            }
            for(int i = min; i <= max; ++i) {
                res.add(columnMap.get(i));
            }
        }
        return res;
    }

}
