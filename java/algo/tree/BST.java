package algo.tree;

import algo.TreeNode;

public class BST {


    /**
     * 在BST中删除元素
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root.val == key) {
            // 找到啦，进行删除

            // 左右子节点都为空时，直接返回空
            if (root.left == null && root.right == null) {
                return null;
            }
            // 左节点为空或者右节点为空时，将剩下的那个节点作为当前节点即可
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 左右子都不为空，需要找到左子树最大的节点或者右子树最小的节点
            // 找到右子树的最小节点
            TreeNode minNode = getMin(root.right);
            // 把 root 改成 minNode
            root.val = minNode.val;
            // 转而去删除 minNode
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val > key) {
            // 去左子树找
            root.left = deleteNode(root.left, key);
        } else {
            // 去右子树找
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.left != null) node = node.left;
        return node;
    }

    /**
     * 向BST中插入元素
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null) return new TreeNode(val);
        // if (root.val == val)
        //     BST 中一般不会插入已存在元素
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }

    /**
     * 遍历BST的流程，类似一个更简单的二分查找
     */
    public boolean isInBST2(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        if (root.val < target) {
            return isInBST2(root.right, target);
        } else {
            return isInBST2(root.left, target);
        }
    }

    /**
     * 判断target是否在二叉查找树中，但是遍历了所有节点
     */
    public boolean isInBST(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        // 当前节点没找到就递归地去左右子树寻找
        return isInBST(root.left, target) || isInBST(root.right, target);
    }

}
