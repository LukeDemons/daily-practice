package algo.tree;

import algo.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 *
 * 2021-04-25 每日一题
 * 重拳出击
 */
public class TreeLC897 {

    public static void main(String[] args) {
        TreeLC897 instance = new TreeLC897();

        TreeNode result = instance.increasingBST(TreeNode.init(5,3,6,2,4,null,8,1,null,null,null,7,9));

        TreeNode.bfs(result);
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);

        // 重新构建要求的树结构
        TreeNode dummyNode = new TreeNode(-1);
        TreeNode curNode = dummyNode;
        for (int value : result) {
            curNode.right = new TreeNode(value);
            curNode = curNode.right;
        }
        return dummyNode.right;
    }

    /**
     * 中序遍历得到按序排列的集合
     */
    public void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}
