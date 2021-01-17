package algo.bit;

/**
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 */
public class BitLC201 {

    public static void main(String[] args) {
        BitLC201 instance = new BitLC201();
        int result = instance.rangeBitwiseAnd(5, 7);
        System.out.println(result);
    }

    /**
     * m和n之间所有数字的按位与，相当于公共前缀。
     * 先记一下向右移了多少位之后，大数不再是大数，原大数小于等于原小数，再移回来就行
     */
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m < n) {
            shift++;
            m >>= 1;
            n >>= 1;
        }

        return m << shift;
    }

    /**
     * 大数逐个去掉末位的1，直至大数等于或小于小数时，这时大数的值
     */
    public int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            n = n & n - 1;
        }

        return n;
    }
}
