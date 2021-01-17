package algo.factorial;

/**
 * @author yanchuang
 * @date 2020/8/29
 */
public class FactorialLC172 {

    public static void main(String[] args) {
        FactorialLC172 instance = new FactorialLC172();

        int result = instance.trailingZeroes(5);

        System.out.println(result);
    }

    public int trailingZeroes(int n) {
        int res = 0;
        long divisor = 5;
        while (n >= divisor) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }
}
