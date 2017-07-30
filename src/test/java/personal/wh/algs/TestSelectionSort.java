package personal.wh.algs;

import personal.wh.algs.sort.SelectionSort;
import personal.wh.algs.sort.util.Utils;

public class TestSelectionSort {

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectionSort<Integer> sort = new SelectionSort<>();
        sort.sort(arr);
        Utils.printArray(arr);
    }
    
}
