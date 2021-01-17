package algo.tree;

import algo.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * DFS & BFS
 */
public class TreeTraverse {

    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        System.out.println("*******treeHeight: " + treeHeight(root));

//        DFSWithRecursion(root);
//        DFSWithStack(root);
//        DFSWithStackIN(root);

//        BFSWithQueue(root);
        System.out.println(BFS(root));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;

        return root;
    }

    public static int treeHeight(TreeNode node) {
        if (node == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int front = 0;
        int rear = queue.size();
        int floor = 0;

        while (!queue.isEmpty()) {
            node = queue.poll();
            front++;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (front == rear) {
                front = 0;
                rear = queue.size();
                floor++;
            }
        }
        return floor;
    }

    /**
     * inorder
     */
    public static void DFSWithRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            DFSWithRecursion(node.left);
        }
        System.out.println(node.val);
        if (node.right != null) {
            DFSWithRecursion(node.right);
        }
    }

    /**
     * preorder
     */
    public static void DFSWithStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.println(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }

    public static void DFSWithStackIN(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            while (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }
            TreeNode top = stack.pop();
            System.out.println(top.val);
            if (top.right != null) {
                stack.push(top.right);
                root = top.right;
            }
        }
    }

    //使用Queue实现BFS
    public static void BFSWithQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.val);
            if (treeNode.left != null)
                queue.add(treeNode.left);
            if (treeNode.right != null)
                queue.add(treeNode.right);
        }
    }

    public static List<List<Integer>> BFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
                list.add(cur.val);
            }
            result.add(list);
        }

        return result;
    }

}