package algo.tree;

import algo.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * 锯齿遍历
 */
public class TreeLC103 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.init(1, 2, 3, 4, null, null, 5);

        List<List<Integer>> result = new TreeLC103().zigzagLevelOrder(root);

        System.out.println(result);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(cur.val);
                } else {
                    levelList.offerFirst(cur.val);
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

            }
            result.add(new ArrayList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return result;
    }
}
