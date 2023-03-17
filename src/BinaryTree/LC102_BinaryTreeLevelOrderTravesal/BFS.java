package BinaryTree.LC102_BinaryTreeLevelOrderTravesal;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            // need to keep the number of nodes because node number differs in levels
            int size = queue.size();
            // store current level node
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i< size; i++) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(curLevel);

        }
        return res;
    }
}
