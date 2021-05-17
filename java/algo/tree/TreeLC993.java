package algo.tree;

import algo.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 * <p>
 * 2021-05-17 每日一题
 * easy 重拳出击。。。
 */
public class TreeLC993 {

    public static void main(String[] args) {
        TreeLC993 instance = new TreeLC993();

//        boolean result = instance.isCousins(TreeNode.init(1, 2, 3, 4), 4, 3);
        boolean result = instance.isCousins(TreeNode.init(1, 2, 3, null, 4, null, 5), 4, 5);

        System.out.println(result);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        traverse(root, null, 0, x, y);

        return result.size() == 2 && result.get(x)[0].equals(result.get(y)[0]) && !result.get(x)[1].equals(result.get(y)[1]);
    }

    Map<Integer, Integer[]> result = new HashMap<>(2);

    private void traverse(TreeNode node, Integer pVal, int level, int x, int y) {
        if (node == null) {
            return;
        }
        traverse(node.left, node.val, level + 1, x, y);
        if (node.val == x || node.val == y) {
            result.put(node.val, new Integer[]{level, pVal});
            System.out.println(level + ":" + pVal);
        }

        traverse(node.right, node.val, level + 1, x, y);
    }
}
