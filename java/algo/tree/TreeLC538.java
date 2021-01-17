package algo.tree;

import algo.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 *
 * 这题和1038题是同一道题
 */
public class TreeLC538 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.init(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8);

        TreeLC538 instance = new TreeLC538();
        TreeNode.bfs(root);
        instance.convertBST(root);
        TreeNode.bfs(root);
    }

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum = 0;
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
