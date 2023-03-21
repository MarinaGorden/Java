package BinaryTree.LC103_BinaryTreeZigzagLevelOrderTraversal;

import BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to
right, then right to left for the next level and alternate between).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
*/
public class BFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res =new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean left_to_right = true;
        // while iterate from up to down
        while (!queue.isEmpty()) {
            // record the node number of the level
            int size = queue.size();
            LinkedList<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // zigzag iteration
                // from-left-to-right: insert at tail; from-right-to-left: insert at head
                if (left_to_right) curLevel.addLast(node.val);
                else curLevel.addFirst(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            // change the direction when one level iteration is over
            left_to_right = false;
            res.add(curLevel);
        }
        return res;
    }
}
