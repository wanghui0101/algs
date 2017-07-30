package personal.wh.algs.sort.util;

import java.util.Arrays;
import java.util.Random;

public class Utils {
    
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static Integer[] generateRandomArray(int n, int min, int max) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Random().nextInt(max - min + 1) + min;
        }
        return arr;
    }
    
    public static Integer[] generateRandomArrayNearlySorted(int n, int min, int max, int swapTimes) {
        Integer[] arr = generateRandomArray(n, min, max);
        for (int i = 0; i < swapTimes; i++) {
            int x = new Random().nextInt(n);
            int y = new Random().nextInt(n);
            swap(arr, x, y);
        }
        return arr;
    }

    public static final <T> void printArray(T[] arr) {
        Arrays.toString(arr);
    }
    
    public static <T extends Comparable<T>> void isSorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                throw new RuntimeException("没排好序");
            }
        }
        System.out.println("已排好序");
    }
    
}
