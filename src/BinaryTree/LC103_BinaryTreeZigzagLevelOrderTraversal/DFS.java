package BinaryTree.LC103_BinaryTreeZigzagLevelOrderTraversal;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
// Time O(N) | Space O(N)
public class DFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        DFS(root, 0, res);
        return res;
    }

    private void DFS(TreeNode node, int level, List<List<Integer>> res) {
        List<Integer> curLevel;
        if (node == null) return;
        if (level < res.size()) curLevel = res.get(level);
        else {
            curLevel = new ArrayList<>();
            res.add(curLevel);
        }
        // odd level insert node in the head
        if (level % 2 != 0) curLevel.add(0, node.val);
        else curLevel.add(node.val);
        DFS(node.left, level + 1, res);
        DFS(node.right, level + 1, res);
    }
}
