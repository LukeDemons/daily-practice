package algo.array;

/**
 * https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
 */
public class ArrayLC1232 {

    public static void main(String[] args) {
        ArrayLC1232 instance = new ArrayLC1232();

        boolean result = instance.checkStraightLine(new int[][]{{2,1}, {4,2}, {6,3}});

        System.out.println(result);
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int[] arr1 = coordinates[0];
        int[] arr2 = coordinates[1];
        if (arr2[0] == arr1[0]) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != arr1[0]) {
                    return false;
                }
            }
            return true;
        }
        double slope = (double) (arr2[1] - arr1[1]) / (arr2[0] - arr1[0]);

        for (int i = 2; i < coordinates.length; i++) {
            if (coordinates[i][1] - arr1[1] != (coordinates[i][0] - arr1[0]) * slope) {
                return false;
            }
        }
        return true;
    }
}
