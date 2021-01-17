package algo.bit;

/**
 * https://leetcode-cn.com/problems/hamming-distance/
 */
public class BitLC461 {

    public static void main(String[] args) {
        BitLC461 instance = new BitLC461();
        int d = instance.hammingDistance(4, 2);

        System.out.println(d);
    }

    /**
     * 先计算异或值，接下来只要数一下这个值中有多少个1就可以了
     */
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;

        int distance = 0;
        while (xor > 0) {
            if ((xor & 1) == 1) {
                distance++;
            }
            xor >>= 1;
        }

        return distance;
    }

    /**
     * 计算有多少个1的时候可以使用 布赖恩·克尼根 算法，n&n-1相当于去掉末位的1
     */
    public int hammingDistance2(int x, int y) {
        int xor = x ^ y;

        int distance = 0;
        while (xor > 0) {
            distance++;
            xor = xor & xor - 1;
        }

        return distance;
    }

}
