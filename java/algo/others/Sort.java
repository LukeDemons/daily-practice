package algo.others;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 12, 5};

        printArr(arr);
        arr = insertionSort(arr);
        printArr(arr);
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        int partitionIndex = index - 1;
        quickSort(arr, left, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, right);
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // 插入排序的升级版
    private static int[] shellSort(int[] arr) {
        int number = arr.length / 2;
        int i;
        int j;
        int temp;
        while (number >= 1) {
            for (i = number; i < arr.length; i++) {
                temp = arr[i];
                j = i - number;
                while (j >= 0 && arr[j] < temp) {
                    arr[j + number] = arr[j];
                    j = j - number;
                }
                arr[j + number] = temp;
            }
            number = number / 2;
        }

        return arr;
    }


    private static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }

        return arr;
    }


    private static int[] insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int j = i;

            while (j > 0 && cur < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = cur;
        }
        return arr;
    }

    private static int[] bubbleSort(int[] arr) {
        if (arr.length <= 1) return arr;

        for (int i = 0; i < arr.length; i++) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) { // 交换
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                }
            }
            if (!flag) {  // 没有数据交换，提前退出
                break;
            }
        }

        return arr;
    }

    private static void printArr(int[] arr) {
        for (int a : arr) {
            System.out.print(a + "\t");
        }
        System.out.println();
    }
}
