package algo.tree;

import algo.TreeNode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class TreeLC230 {

    public static void main(String[] args) {
        TreeLC230 instance = new TreeLC230();

        int result = instance.kthSmallest(TreeNode.init(5, 3, 6, 2, 4, null, null, 1), 1);

        System.out.println(result);
    }

    int res = 0;
    int cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        // 升序遍历（中序）找第k个即可
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null || k == 0) {
            return;
        }
        traverse(root.left, k);
        cnt++;
        if (cnt == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }

    public int kthSmallestALL(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> sortedList = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            sortedList.add(cur.val);

            if (cur.left != null) {
                queue.add(cur.left);
            }

            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        sortedList.sort(Comparator.comparingInt(a -> a));

        return sortedList.get(k - 1);
    }
}
