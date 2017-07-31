package personal.wh.algs.sort.util;

import personal.wh.algs.sort.BubbleSort;
import personal.wh.algs.sort.InsertionSort;
import personal.wh.algs.sort.MergeSort;
import personal.wh.algs.sort.QuickSort;
import personal.wh.algs.sort.SelectionSort;
import personal.wh.algs.sort.ShellSort;
import personal.wh.algs.sort.Sort;

public abstract class SortUtils {

    private enum SortAlgs {
        BUBBLE(new BubbleSort()),
        SELECTION(new SelectionSort()),
        INSERTION(new InsertionSort()),
        SHELL(new ShellSort()),
        MERGE(new MergeSort()),
        QUICK(new QuickSort());
        
        private final Sort sort;
        
        private SortAlgs(Sort sort) {
            this.sort = sort;
        }
    }
    
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        SortAlgs.BUBBLE.sort.sort(arr);
    }
    
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        SortAlgs.SELECTION.sort.sort(arr);
    }
    
    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        SortAlgs.INSERTION.sort.sort(arr);
    }
    
    public static <T extends Comparable<T>> void shellSort(T[] arr) {
        SortAlgs.SHELL.sort.sort(arr);
    }
    
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        SortAlgs.MERGE.sort.sort(arr);
    }
    
    public static <T extends Comparable<T>> void quickSort(T[] arr) {
        SortAlgs.QUICK.sort.sort(arr);
    }
    
}
