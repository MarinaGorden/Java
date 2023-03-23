package BinaryTree.LC101_SymmetricTree;

import BinaryTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
*/
public class PreOrderTraverse {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        deque.offerLast(root);

        while(!deque.isEmpty()) {
            TreeNode left = deque.pollLast();
            TreeNode right = deque.pollLast();
            if (left == null && right == null) continue;
            if ((left == null || right == null) || left.val != right.val) return false;

            deque.offerLast(left.right);
            deque.offerLast(right.left);
            deque.offerLast(left.left);
            deque.offerLast(right.right);
        }
        return true;
    }
}
