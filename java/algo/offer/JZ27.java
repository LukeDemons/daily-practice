package algo.offer;

import algo.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * <p>
 * 2021-05-18 有点累 来个easy吧
 */
public class JZ27 {

    public static void main(String[] args) {
        JZ27 instance = new JZ27();

        TreeNode result = instance.mirrorTree(TreeNode.init(4, 2, 7, 1, 3, 6, 9));

        TreeNode.bfs(result);
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
