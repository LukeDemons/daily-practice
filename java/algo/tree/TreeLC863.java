package algo.tree;

import algo.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 * <p>
 * 2021-07-28 每日一题
 * dfs的基础灵活运用
 */
public class TreeLC863 {

    public static void main(String[] args) {
        TreeLC863 instance = new TreeLC863();

        // 测试用例构造有问题
        List<Integer> result = instance.distanceK(TreeNode.init(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4),
                TreeNode.init(5, 6, 2, null, null, 7, 4), 2);

        System.out.println(result);
    }

    Map<Integer, TreeNode> parents = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 从 root 出发 DFS，记录每个节点的父节点
        findParents(root);

        // 从 target 出发 DFS，寻找所有深度为 k 的节点，从左、右、根三个方向dfs
        findResult(target, null, 0, k);

        return result;
    }

    private void findParents(TreeNode node) {
        // 这里进入循环的node一定不会为null，所以不用做判空
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    private void findResult(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            result.add(node.val);
            return;
        }
        if (node.left != from) {
            findResult(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            findResult(node.right, node, depth + 1, k);
        }
        if (parents.get(node.val) != from) {
            findResult(parents.get(node.val), node, depth + 1, k);
        }
    }
}
