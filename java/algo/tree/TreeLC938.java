package algo.tree;

import algo.TreeNode;

/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * <p>
 * 2021-04-27 每日一题
 * 重拳出击，但是蹦迪谢天笑没有打卡
 */
public class TreeLC938 {

    public static void main(String[] args) {
        TreeLC938 instance = new TreeLC938();

        int result = instance.rangeSumBST(TreeNode.init(10, 5, 15, 3, 7, null, 18), 7, 15);

        System.out.println(result);
    }

    int result = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return result;
    }

    public void inorder(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }
        inorder(node.left, low, high);
        if (node.val >= low && node.val <= high) {
            result += node.val;
        }
        inorder(node.right, low, high);
    }
}
