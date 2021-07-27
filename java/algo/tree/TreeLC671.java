package algo.tree;

import algo.TreeNode;

/**
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 * <p>
 * 2021-07-27 每日一题
 * 由于数据分布情况，必须遍历整棵树才行。所以还可以拿出所有val排序
 */
public class TreeLC671 {

    public static void main(String[] args) {
        TreeLC671 instance = new TreeLC671();

        int result = instance.findSecondMinimumValue(TreeNode.init(2, 2, 5, null, null, 5, 7));

        System.out.println(result);
    }

    int result = -1;

    public int findSecondMinimumValue(TreeNode root) {
        traverse(root, root.val);
        return result;
    }

    private void traverse(TreeNode node, int minVal) {
        if (node == null) {
            return;
        }
        // 这里前中后序遍历都可以，需要把整棵树都遍历完才行
        traverse(node.left, minVal);
        if (node.val != minVal) {
            if (result == -1) {
                result = node.val;
            } else {
                result = Math.min(result, node.val);
            }
            return;
        }
        traverse(node.right, minVal);
    }
}
