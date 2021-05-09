package algo.tree;

import algo.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * <p>
 * 2021-05-10 趁热打铁
 */
public class TreeLC106 {

    public static void main(String[] args) {
        TreeLC106 instance = new TreeLC106();

        TreeNode node = instance.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});

        TreeNode.bfs(node);
    }

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode recursive(int[] postorder, int inLeft, int inRight, int posLeft, int posRight) {
        if (inLeft > inRight || posLeft > posRight) {
            return null;
        }

        int root = map.get(postorder[posRight]);

        TreeNode node = new TreeNode(postorder[posRight]);

        node.left = recursive(postorder, inLeft, root - 1, posLeft, root - inLeft + posLeft - 1);
        node.right = recursive(postorder, root + 1, inRight, root - inLeft + posLeft, posRight - 1);
        return node;
    }
}
