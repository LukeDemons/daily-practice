package algo.tree;

import algo.TreeNode;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 *
 * 二叉树删除节点
 */
public class TreeLC450 {

    public static void main(String[] args) {
        TreeLC450 instance = new TreeLC450();

        TreeNode tree = TreeNode.init(5, 3, 6, 2, 4, null, 7);

        TreeNode.bfs(tree);

        instance.deleteNode(tree, 3);

        TreeNode.bfs(tree);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode replace = getMax(root.left);
            root.val = replace.val;
            root.left = deleteNode(root.left, replace.val);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    private TreeNode getMax(TreeNode root) {
        while (root.right != null) root = root.right;
        return root;
    }
}
