package BinaryTree.LC100_SameTree;

import BinaryTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class PreOrderTraverse {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(p);
        deque.offerLast(q);

        while(!deque.isEmpty()) {
            p = deque.pollLast();
            q = deque.pollLast();
            if (p == null &&  q == null) continue;
            if ((p == null || q == null) || (p.val != q.val)) return false;
            deque.offerLast(p.left);
            deque.offerLast(q.left);
            deque.offerLast(p.right);
            deque.offerLast(q.right);
        }
        return true;
    }
}
