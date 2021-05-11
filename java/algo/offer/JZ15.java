package algo.offer;

/**
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * <p>
 * 2021-05-12 bitCount
 *
 * @see algo.bit.BitLC191
 */
public class JZ15 {

    public static void main(String[] args) {
        JZ15 instance = new JZ15();

        int result = instance.hammingWeight1(11);

        System.out.println(result);
    }

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight1(int n) {
        int bits = 0;
        while (n != 0) {
            // 和1与，判断最后一个值是不是1
            bits += n & 1;
            n >>>= 1;
        }
        return bits;
    }

    public int hammingWeight2(int n) {
        int bits = 0;
        while (n != 0) {
            bits++;
            // 去掉最后一个1，每去掉一个1，bit加1
            n &= n - 1;
        }
        return bits;
    }
}
