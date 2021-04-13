package algo.tree;

import algo.TreeNode;

/**
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 *
 * 2021-04-13 每日一题
 * 中序遍历就能搞定，就是没想明白的是为什么不能把全局变量带到递归参数里面
 */
public class TreeLC783 {

    public static void main(String[] args) {
        TreeLC783 instance = new TreeLC783();

//        int result = instance.minDiffInBST(TreeNode.init(4,2,6,1,3));
        int result = instance.minDiffInBST(TreeNode.init2(27,null,34,null,58,50,null,44));

        System.out.println(result);
    }

    int delta = Integer.MAX_VALUE;
    Integer lastOne = null;
    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return delta;
    }

    // 中序遍历我也想到了，没想明白的是为什么不能把全局变量带到递归参数里面
    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        if (lastOne != null) {
            delta = Math.min(delta, node.val - lastOne);
        }
        lastOne = node.val;
        traverse(node.right);
    }
}
