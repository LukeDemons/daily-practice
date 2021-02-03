package algo;

public class Search {

    public static void main(String[] args) {
        Search instance = new Search();

        System.out.println(instance.binarySearch(new int[]{1, 2, 3}, 4));
    }

    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
