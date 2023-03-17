package BinaryTree.LC102_BinaryTreeLevelOrderTravesal;

import BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right,
level by level).*/
public class BFSWithRecursion {
    // Time O(N) | Space O(N)
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new LinkedList<>();
        if (root == null) return res;
        traverse(root, 0);
        return res;
    }

    public void traverse(TreeNode node, int level) {
        if (node == null) return;
        if (level == res.size()) res.add(new ArrayList<>());
        res.get(level).add(node.val);
        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }
}
