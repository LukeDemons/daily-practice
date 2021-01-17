package algo.tree;

import algo.TreeNode;

/**
 * https://leetcode-cn.com/problems/same-tree/
 */
public class TreeLC100 {

    public static void main(String[] args) {
        TreeLC100 instance = new TreeLC100();

        boolean result = instance.isSameTree(TreeNode.init(1, 2, 3), TreeNode.init2(1, 2, 3));

        System.out.println(result);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        if (q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left & right;
    }
}
