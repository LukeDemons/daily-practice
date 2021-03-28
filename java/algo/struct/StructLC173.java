package algo.struct;

import algo.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 *
 * 2021-03-28 每日一题
 * 一次ac，最好理解的struct题解就是在构造里把数据维护好，，当然本题希望考察的还是栈的用法？
 */
public class StructLC173 {

    public static void main(String[] args) {
        BSTIterator instance = new BSTIterator(TreeNode.init(7, 3, 15, null, null, 9, 20));

        System.out.println(instance.next());
        System.out.println(instance.next());
        System.out.println(instance.hasNext());
        System.out.println(instance.next());
        System.out.println(instance.hasNext());
        System.out.println(instance.next());
        System.out.println(instance.hasNext());
        System.out.println(instance.next());
        System.out.println(instance.hasNext());
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
class BSTIterator {
    Queue<Integer> inorder = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        inorder.add(root.val);
        inorder(root.right);
    }

    public int next() {
        return inorder.poll();
    }

    public boolean hasNext() {
        return !inorder.isEmpty();
    }
}