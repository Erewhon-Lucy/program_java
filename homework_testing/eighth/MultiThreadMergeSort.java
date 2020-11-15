package homework_testing.eighth;

import java.util.Arrays;

public class MultiThreadMergeSort {
    public static void mergeArrays(int[] a, int[] b) {
        int[] resultArr = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int r = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                resultArr[r] = a[i];
                i++;
            } else {
                resultArr[r] = b[j];
                j++;
            }
            r++;
            if (i == a.length) {
                while (j < b.length) {
                    resultArr[r] = b[j];
                    r++;
                    j++;
                }
            }
            if (j == b.length) {
                while (i < a.length) {
                    resultArr[r] = a[i];
                    r++;
                    i++;
                }
            }
        }
    }

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

    public static void main(String[] args) throws InterruptedException {
        int[] original = Array.randomArray();

        //Test 2-thread merge sort
        long startTime = System.currentTimeMillis();
        int[] subArr1 = new int[original.length / 2];
        int[] subArr2 = new int[original.length - original.length / 2];
        System.arraycopy(original, 0, subArr1, 0, original.length / 2);
        System.arraycopy(original, original.length / 2, subArr2, 0, original.length - original.length / 2);

        MyThread runner1 = new MyThread(subArr1);
        MyThread runner2 = new MyThread(subArr2);
        runner1.start();
        runner2.start();
        runner1.join();
        runner2.join();
        mergeArrays(runner1.getThreadArr(), runner2.getThreadArr());
        long stopTime = System.currentTimeMillis();
        long useTime = stopTime - startTime;
        System.out.println("2-thread MergeSort uses: " + useTime + " ms");

        //Then compare to 1-thread quick sort
        int[] quickArr = new int[10000000];
        System.arraycopy(original, 0, quickArr, 0, 10000000);
        long startTime2 = System.currentTimeMillis();
        quickSort(quickArr, 0, 9999999);
        System.out.println("Quick Sort uses:" + (System.currentTimeMillis() - startTime2) + "ms");

        //Then compare to Array.sort()
        long startTime3 = System.currentTimeMillis();
        Arrays.sort(original);
        System.out.println("Array.sort() uses:" + (System.currentTimeMillis() - startTime3) + "ms");
    }

}

class MyThread extends Thread {
    private final int[] threadArr;

    public int[] getThreadArr() {
        return threadArr;
    }

    public void mergeSort(int[] array) {
        if (array.length > 1) {
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    public int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        System.arraycopy(array, 0, left, 0, size1);
        return left;
    }

    public int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        if (size2 >= 0)
            System.arraycopy(array, size1, right, 0, size2);
        return right;
    }

    public void merge(int[] result, int[] left, int[] right) {
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }

    MyThread(int[] arr) {
        threadArr = arr;
    }

    public void run() {
        mergeSort(threadArr);
    }
}

class Array {
    static int len = 10000000;

    public static int[] randomArray() {
        int[] arr = new int[Array.len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * Array.len);
        }
        return arr;
    }
}
