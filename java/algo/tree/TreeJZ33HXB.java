package algo.tree;

/**
 * @author yanchuang
 * @date 2020/7/11
 */
public class TreeJZ33HXB {

    public static void main(String[] args) {
        TreeJZ33HXB hxb = new TreeJZ33HXB();
//        boolean result = hxb.isBST(new int[]{5, 7, 6, 9, 11, 10, 8});
        boolean result = hxb.isBST(new int[]{7, 4, 6, 5});
        System.out.println(result);
    }

    public boolean isBST(int[] arr) {
        if (arr == null) return false;

        return helper(arr, 0, arr.length - 1);
    }

    public boolean helper(int[] arr, int left, int right) {
        if (left >= right) {
            return true;
        }
        int mid = left;

        while (arr[left] < arr[right]) {
            left++;
        }
        for (int i = left; i < right; i++) {
            if (arr[i] < arr[right]) {
                return false;
            }
        }

        boolean leftB = helper(arr, mid, left - 1);
        boolean rightB = helper(arr, left, right - 1);
        return leftB && rightB;
    }
}
