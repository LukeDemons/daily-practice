package algo.offer;

import algo.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * <p>
 * 2021-05-09 向薛霸看齐
 */
public class JZ07 {

    public static void main(String[] args) {
        JZ07 instance = new JZ07();

        TreeNode result = instance.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        TreeNode.bfs(result);
    }

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(preorder, 0, 0, inorder.length - 1);
    }

    private TreeNode recursive(int[] preorder, int preRoot, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preRoot]);
        int inRoot = map.get(preorder[preRoot]);
        //左子树的 先序根索引为原先序根节点+1，左边界为原中序inLeft，右边界为原中序根节点-1
        node.left = recursive(preorder, preRoot + 1, inLeft, inRoot - 1);
        //右子树的 先序根索引为 (中序根节点坐标-中序左边界）+先序根节点坐标+1，左边界为原中序根节点+1，右边界为原中序右边界
        node.right = recursive(preorder, preRoot - inLeft + inRoot + 1, inRoot + 1, inRight);
        return node;
    }

}
