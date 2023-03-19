package BinaryTree.LC107_BinaryTreeLevelOrderTraversalII;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSWithLinkedList {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       LinkedList<List<Integer>> res = new LinkedList<>();
       if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        // first in first out
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            // add to the first
            res.addFirst(curLevel);
        }
        return res;
    }
}
