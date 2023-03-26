package BinaryTree.LC110_BalancedBinaryTree;

import BinaryTree.TreeNode;

public class TopDownRecursionII {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) > 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

}