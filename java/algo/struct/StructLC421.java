package algo.struct;

/**
 * https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 *
 * 2021-05-16 每日一题
 * 大概是构造一棵trie树，没有时是null，有值可能0可能1都能到叶子。每加一个值，就能根据树中信息得到当前值和之前值的最大异或值
 */
public class StructLC421 {

    public static void main(String[] args) {
        StructLC421 instance = new StructLC421();

        int result = instance.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});

        System.out.println(result);
    }

    Trie421 root = new Trie421();

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int num : nums) {
            // 把num加到树中
            add(num);
            // 获取num和树中节点异或的最大值
            max = Math.max(max, findMax(num));
        }
        return max;
    }

    public void add(int num) {
        Trie421 cur = root;
        for (int i = 30; i >= 0; i--) {
            // 取出num中第 i+1 位的状态
            int index = num >> i & 1;
            // 如果原来有,就不需要new新的,不然会覆盖原来的
            if (cur.next[index] == null) {
                cur.next[index] = new Trie421();
            }
            cur = cur.next[index];
        }
    }

    public int findMax(int num) {
        Trie421 cur = root;
        int result = 0;
        for (int i = 30; i >= 0; i--) {
            // 取出num中第 i+1 位的状态
            int index = num >> i & 1;

            // 如果这位为1,那么他希望异或0,如果为0,希望异或1
            // 所以把期望坐标取反
            index ^= 1;

            // 如果有期望的值,肯定走期望
            if (cur.next[index] != null) {
                // 结果加上这个值
                result |= (1 << i);
            } else {
                // 说明没有期望的值,只能走另一条路
                // 自然不需要加,当前位的值
                index ^= 1;
            }
            cur = cur.next[index];
        }
        return result;
    }
}

class Trie421 {
    Trie421[] next;

    public Trie421() {
        this.next = new Trie421[2];
    }
}
