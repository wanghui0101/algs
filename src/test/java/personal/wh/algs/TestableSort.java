package personal.wh.algs;

import org.junit.Test;

import personal.wh.algs.sort.BubbleSort;
import personal.wh.algs.sort.InsertionSort;
import personal.wh.algs.sort.MergeSort;
import personal.wh.algs.sort.MergeSort2;
import personal.wh.algs.sort.SelectionSort;
import personal.wh.algs.sort.ShellSort;
import personal.wh.algs.sort.Sort;

public class TestableSort extends TestSupport {

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
    public void testAllMergeSort() {
        Integer[] arr = generateRandomArray(1000000, 0, 1000);
        Integer[] arr2 = arr.clone();
        doTest(new MergeSort(), arr);
        assertSorted(arr);
        doTest(new MergeSort2(), arr2);
        assertSorted(arr2);
    }
    
    private <T extends Comparable<T>> void doTest(Sort sort, T[] arr) {
        long start = System.currentTimeMillis();
        sort.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(sort.getName() + "执行了" + (end - start) + "毫秒");
    }
    
}
