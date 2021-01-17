package algo.tree;

import algo.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class TreeLC105 {
    public static void main(String[] args) {
        TreeLC105 instance = new TreeLC105();

        instance.buildTree(new int[]{1, 2, 3}, new int[]{2, 3, 1});
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = indexMap.get(preorder[preStart]);
        int numsLeft = inRoot - inStart;
        root.left = myBuildTree(preorder, inorder, preStart + 1, preStart + numsLeft, inStart, inRoot - 1);
        root.right = myBuildTree(preorder, inorder, preStart + numsLeft + 1, preEnd, inRoot + 1, inEnd);

        return root;
    }

}
