package algo.tree;

import algo.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * 二叉树展开为链表
 */
public class TreeLC114 {

    public static void main(String[] args) {
        TreeLC114 instance = new TreeLC114();
        TreeNode root = TreeNode.init();

        TreeNode.bfs(root);

        instance.flatten(root);

        TreeNode.bfs(root);
    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void preorder(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        list.add(node);
        preorder(node.left, list);
        preorder(node.right, list);
    }
}
