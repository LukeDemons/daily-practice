package algo.tree;

import algo.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 * <p>
 * 2021-05-10 每日一题
 * 重拳出击
 */
public class TreeLC872 {

    public static void main(String[] args) {
        TreeLC872 instance = new TreeLC872();

        boolean result = instance.leafSimilar(
                TreeNode.init(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4),
                TreeNode.init(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8));

        System.out.println(result);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        getLeaf(root1, leaves1);
        List<Integer> leaves2 = new ArrayList<>();
        getLeaf(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void getLeaf(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        getLeaf(root.left, leaves);
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        getLeaf(root.right, leaves);
    }
}
