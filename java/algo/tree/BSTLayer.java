package algo.tree;

import algo.TreeNode;

public class BSTLayer {

    public static void main(String[] args) {
//        System.out.println(maxHeight(TreeNode.init()));
//        getNodeLayer(TreeNode.init(), 12);
        getNodeLayer2(TreeNode.init(), 12, 1);
    }

    /**
     * 求树高
     */
    public static int maxHeight(TreeNode node) {
        if (node == null) return 0;

        int leftSubTreeMaxHeight = maxHeight(node.left);
        int rightSubTreeMaxHeight = maxHeight(node.right);

        return Math.max(leftSubTreeMaxHeight, rightSubTreeMaxHeight) + 1;
    }

    static int layer = 0;
    boolean flag;

    /**
     * 求某值所在楼层
     */
    public static void getNodeLayer(TreeNode node, int target) {
        if (node == null) return;
        layer++;
        if (node.val == target) {
            System.out.println(layer);
            return;
        }
        getNodeLayer(node.left, target);
        getNodeLayer(node.right, target);
        layer--;
    }

    public static void getNodeLayer2(TreeNode node, int target, int layer2) {
        if (node == null) return;
        if (node.val == target) {
            System.out.println(layer2);
            return;
        }
        getNodeLayer2(node.left, target, layer2 + 1);
        getNodeLayer2(node.right, target, layer2 + 1);
    }


}
