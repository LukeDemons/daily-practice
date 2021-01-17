package algo.greedy;

public class GreedyLC605 {

    public static void main(String[] args) {
        GreedyLC605 instance = new GreedyLC605();

        boolean result = instance.canPlaceFlowers(new int[]{ 0, 0, 1, 0, 1}, 1);

        System.out.println(result);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        // 可以种花的条件
        // 自己为空 &&（自己最左or左边是0）&&（自己最右or右边是0）
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0
                    && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                n--;
                flowerbed[i] = 1;
            }

            if (n <= 0) {
                return true;
            }
        }

        return false;
    }
}
