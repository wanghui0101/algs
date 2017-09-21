package personal.wh.algs;

import org.junit.Test;

import personal.wh.algs.sort.BubbleSort;
import personal.wh.algs.sort.HeapSort;
import personal.wh.algs.sort.InsertionSort;
import personal.wh.algs.sort.MergeSort;
import personal.wh.algs.sort.MergeSort2;
import personal.wh.algs.sort.QuickSort;
import personal.wh.algs.sort.SelectionSort;
import personal.wh.algs.sort.ShellSort;
import personal.wh.algs.sort.Sort;

public class TestSort extends TestSupport {

    @Test
    public void testSelectionSort() {
        Integer[] arr = generateRandomArray(10000, 0, 50);
        doTest(new SelectionSort(), arr);
        assertSorted(arr);
    }
    
    @Test
    public void testBubbleSort() {
        Integer[] arr = generateRandomArray(1000, 0, 50);
        doTest(new BubbleSort(), arr);
        assertSorted(arr);
    }
    
    @Test
    public void testInsertionSort() {
        Integer[] arr = generateRandomArray(1000, 0, 1000);
        doTest(new InsertionSort(), arr);
        assertSorted(arr);
    }
    
    @Test
    public void testShellSort() {
        Integer[] arr = generateRandomArray(1000, 0, 1000);
        doTest(new ShellSort(), arr);
        assertSorted(arr);
    }
    
    @Test
    public void testMergeSort() {
        Integer[] arr = generateRandomArray(1000000, 0, 1000);
        doTest(new MergeSort(), arr);
        assertSorted(arr);
    }
    
    @Test
    public void testMergeSort2() {
        Integer[] arr = generateRandomArray(1000000, 0, 1000);
        doTest(new MergeSort2(), arr);
        assertSorted(arr);
    }
    
    @Test
    public void testQuickSort() {
        Integer[] arr = generateRandomArray(1000000, 0, 1000000);
        doTest(new QuickSort(), arr);
        assertSorted(arr);
    }
    
    @Test
    public void testHeapSort() {
        Integer[] arr = generateRandomArray(10000, 0, 1000000);
        doTest(new HeapSort(), arr);
        assertSorted(arr, false);
    }
    
    @Test
    public void testAll() {
        Integer[] arr = generateRandomArray(10000, 0, 1000000);
        Integer[] arr2 = arr.clone();
        Integer[] arr3 = arr.clone();
        Integer[] arr4 = arr.clone();
        Integer[] arr5 = arr.clone();
        Integer[] arr6 = arr.clone();
        Integer[] arr7 = arr.clone();
        doTest(new SelectionSort(), arr);
        doTest(new BubbleSort(), arr2);
        doTest(new InsertionSort(), arr3);
        doTest(new ShellSort(), arr4);
        doTest(new HeapSort(), arr5);
        doTest(new QuickSort(), arr6);
        doTest(new MergeSort2(), arr7);
        //assertSorted(arr, false);
    }
    
    private <T extends Comparable<T>> void doTest(Sort sort, T[] arr) {
        long start = System.currentTimeMillis();
        sort.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(sort.getName() + "执行了" + (end - start) + "毫秒");
    }
    
}
