package algo.tree;

import algo.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class TreeLC98 {

    public static void main(String[] args) {

    }

    /**
     * 判断是否是有效的二叉搜素树
     * 使用辅助函数，增加函数参数列表，在参数中携带额外信息，将这种约束传递给子树的所有节点，
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        double prev = - Double.MAX_VALUE;
        while (!stack.isEmpty()) {
            while (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }

            TreeNode top = stack.pop();
            if (top.val <= prev) return false;
            prev = top.val;
            if (top.right != null) {
                stack.push(top.right);
                root = top.right;
            }
        }

        return true;
    }
}
