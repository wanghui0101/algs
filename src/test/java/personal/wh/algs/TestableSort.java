package personal.wh.algs;

import org.junit.Test;

import personal.wh.algs.sort.BubbleSort;
import personal.wh.algs.sort.InsertionSort;
import personal.wh.algs.sort.SelectionSort;
import personal.wh.algs.sort.ShellSort;
import personal.wh.algs.sort.Sort;
import personal.wh.algs.sort.util.Utils;

public class TestableSort {

    @Test
    public void testSelectionSort() {
        Integer[] arr = Utils.generateRandomArray(1000, 0, 50);
        Sort sort = new SelectionSort();
        doTest(sort, arr);
        Utils.isSorted(arr);
    }
    
    @Test
    public void testBubbleSort() {
        Integer[] arr = Utils.generateRandomArray(1000, 0, 50);
        Sort sort = new BubbleSort();
        doTest(sort, arr);
        Utils.isSorted(arr);
    }
    
    @Test
    public void testInsertionSort() {
        Integer[] arr = Utils.generateRandomArray(1000, 0, 1000);
        Sort sort = new InsertionSort();
        doTest(sort, arr);
        Utils.isSorted(arr);
    }
    
    @Test
    public void testShellSort() {
        Integer[] arr = Utils.generateRandomArray(1000, 0, 1000);
        Sort sort = new ShellSort();
        doTest(sort, arr);
        Utils.isSorted(arr);
    }
    
    private <T extends Comparable<T>> void doTest(Sort sort, T[] arr) {
        long start = System.currentTimeMillis();
        sort.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(sort.getName() + "执行了" + (end - start) + "毫秒");
    }
    
}
