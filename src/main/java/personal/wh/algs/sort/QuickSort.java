package personal.wh.algs.sort;

import java.util.Random;

public final class QuickSort implements Sort {

    private InsertionSort insertionSort = new InsertionSort();
    
    @Override
    public String getName() {
        return "快速排序";
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        quickSortRecursively(arr, 0, arr.length - 1);
    }

    private <T extends Comparable<T>> void quickSortRecursively(T[] arr, int begin, int end) {
        if (end - begin <= 15) {
            insertionSort.doSort(arr, begin, end);
            return;
        }
        int p = partition(arr, begin, end);
        quickSortRecursively(arr, begin, p - 1);
        quickSortRecursively(arr, p + 1, end);
    }
    
    private <T extends Comparable<T>> int partition(T[] arr, int begin, int end) {
        int randomIndex = new Random().nextInt(end - begin + 1) + begin;
        swap(arr, begin, randomIndex);
        T v = arr[begin]; // 随机索引值
        
        int j = begin;
        for (int i = j + 1; i <= end; i++) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, j + 1);
                j++;
            }
        }
        swap(arr, begin, j);
        return j;
    } 
}
