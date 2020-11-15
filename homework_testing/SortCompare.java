package homework_testing;
import java.util.Arrays;

public class SortCompare {
    public static void main(String[] args) {
        // 生成含有50000个0~50000的数的随机数组
        int[] arr = randomArray(500000, 500000);
        // 将随机数组复制到arr2,arr3中
        int[] arr2 = new int[500000];
        int[] arr3 = new int[500000];
        System.arraycopy(arr, 0, arr2, 0, 500000);
        System.arraycopy(arr, 0, arr3, 0, 500000);

        // 使用Array.sort()方法排序，并记录其所用时间
        long start = System.currentTimeMillis();
        Arrays.sort(arr);
        System.out.println("Array.sort() uses:" + (System.currentTimeMillis() - start) + "ms");

        // 使用冒泡排序方法排序，并记录其所用时间
//        long start2 = System.currentTimeMillis();
//        bubbleSort(arr2);
//        System.out.println("Bubble Sort uses:" + (System.currentTimeMillis() - start2) + "ms");

        // 使用快速排序方法排序，并记录其所用时间
        long start3 = System.currentTimeMillis();
        quickSort(arr3, 0, 499999);
        System.out.println("Quick Sort uses:" + (System.currentTimeMillis() - start3) + "ms");
    }

    public static int[] randomArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

//    public static void bubbleSort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//    }

    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;

        temp = arr[low];

        while (i < j) {

            while (temp <= arr[j] && i < j) {
                j--;
            }

            while (temp >= arr[i] && i < j) {
                i++;
            }

            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }

        arr[low] = arr[i];
        arr[i] = temp;

        quickSort(arr, low, j - 1);

        quickSort(arr, j + 1, high);
    }
}
