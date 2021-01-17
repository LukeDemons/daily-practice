package algo.tree;

import algo.TreeNode;

/**
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 */
public class TreeLC701 {

    public static void main(String[] args) {
        TreeLC701 instance = new TreeLC701();

        TreeNode tree = TreeNode.init(5, 3, 6, 2, 4, null, 7);

        TreeNode.bfs(tree);

        instance.insertIntoBST(tree, 3);

        TreeNode.bfs(tree);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

//        if (root.val == val)
        if (root.val <= val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
