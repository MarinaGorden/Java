package BinaryTree.LC107_BinaryTreeLevelOrderTraversalII;

import BinaryTree.TreeNode;

import java.util.*;

public class BFSWithRecursion {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         res = new ArrayList<>();
        if (root == null) return res;
        traverse(root, 0);
        Collections.reverse(res);
        return res;
    }

    public void traverse(TreeNode node, int level) {
        if (node == null) return;
        if (level == res.size()) res.add(new ArrayList<>());
        if (node.left != null) traverse(node.left, level + 1);
        if (node.right != null) traverse(node.right, level + 1);
    }
}
