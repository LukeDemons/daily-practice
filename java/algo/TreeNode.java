package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yanchuang
 * @date 2020/7/4
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode init(Integer... arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();        // 用一个集合来存放每一个Node
        for (Integer i : arr) {
            if (i == null) {
                list.add(null);
            } else {
                list.add(new TreeNode(i));              // list中存着每一个结点
            }
        }
        for (int i = 0; i < arr.length / 2 - 1; i++) {  // i表示的是根节点的索引，从0开始
            TreeNode cur = list.get(i);
            if (cur == null) continue;
            if (list.get(2 * i + 1) != null) {
                // 左结点
                list.get(i).left = list.get(2 * i + 1);
            }
            if (list.get(2 * i + 2) != null) {
                // 右结点
                list.get(i).right = list.get(2 * i + 2);
            }
        }
        // 判断最后一个根结点：因为最后一个根结点可能没有右结点，所以单独拿出来处理
        int lastIndex = arr.length / 2 - 1;
        // 左结点
        list.get(lastIndex).left = list.get(lastIndex * 2 + 1);
        // 右结点，如果数组的长度为奇数才有右结点
        if (arr.length % 2 == 1) {
            list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
        }
        return list.get(0);
    }

    public static TreeNode init() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode12 = new TreeNode(12);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        treeNode4.left = treeNode8;
        treeNode5.left = treeNode9;
        treeNode6.left = treeNode10;
        treeNode7.left = treeNode11;
//        treeNode7.right = treeNode12;

        treeNode11.left = treeNode12;

        return treeNode;
    }

    public static void bfs(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                System.out.print(top.val + "\t");
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
        }
        System.out.println();
    }


    public static TreeNode init2(Integer... arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        return helper(arr, 0);
    }

    private static TreeNode helper(Integer[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }

        Integer val = arr[index];
        if (val == null) {
            return null;
        }

        TreeNode node = new TreeNode(val);
        node.left = helper(arr, index * 2 + 1);
        node.right = helper(arr, index * 2 + 2);
        return node;
    }
}
