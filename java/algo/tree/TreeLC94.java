package algo.tree;

import algo.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 */
public class TreeLC94 {

    public static void main(String[] args) {
        TreeLC94 instance = new TreeLC94();

        instance.inorderTraversal2(TreeNode.init());
    }

    List<Integer> result;
    public TreeLC94() {
        result = new ArrayList<>();
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);

        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop(); // equals pop()
            result.add(cur.val);
            cur = cur.right;
        }

        return result;
    }
}
