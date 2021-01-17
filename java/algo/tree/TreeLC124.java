package algo.tree;

import algo.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 */
public class TreeLC124 {

    static int maxSize = Integer.MIN_VALUE;
    public static void main(String[] args) {
        System.out.println(maxPathSum(TreeNode.init()));
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        oneSideMax(root);

        return maxSize;
    }

    public static int oneSideMax(TreeNode root) {
        if (root == null) return 0;

        int leftMax = Math.max(oneSideMax(root.left), 0);
        int rightMax = Math.max(oneSideMax(root.right), 0);

        maxSize = Math.max(maxSize, leftMax + rightMax + root.val);

        return root.val + Math.max(leftMax, rightMax);
    }
}
