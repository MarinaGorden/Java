package BinaryTree.LC199_BinaryTreeRightSideView;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res  = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    public void dfs(TreeNode node, int level, List<Integer> res) {
        if (node == null) return;
        if (level == res.size()) res.add(node.val);
        dfs(node.right,level + 1, res);
        dfs(node.left, level + 1, res);
    }
}
