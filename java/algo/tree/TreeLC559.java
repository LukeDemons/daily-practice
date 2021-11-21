package algo.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2021-11-21 每日一题
 * 注意多叉树和二叉树的区别
 * <p>
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class TreeLC559 {

    public static void main(String[] args) {
        TreeLC559 instance = new TreeLC559();

        int result = instance.maxDepth(Node.maxDepthInit(1, null, 3, 2, 4, null, 5, 6));

        System.out.println(result);
    }

    /**
     * bfs的思路
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int result = 0;
        while (!queue.isEmpty()) {
            // size 存放当前层的节点个数，二叉树模版里面固定了size
            int size = queue.size();
            while (size > 0) {
                size--;
                for (Node child : queue.poll().children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
            result++;
        }
        return result;
    }

    public int maxDepthDFS(Node root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        for (Node child : root.children) {
            result = Math.max(result, maxDepthDFS(child));
        }
        // 需要再加上root节点对应的深度
        return result + 1;
    }
}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public static Node maxDepthInit(Integer... arr) {
        // 不会构建..
        return null;
    }
}
