package algo.tree;

import algo.TreeNode;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class TreeLC700 {

    public static void main(String[] args) {
        TreeLC700 instance = new TreeLC700();

        instance.searchBST(TreeNode.init(1, 2, 3), 2);

    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
