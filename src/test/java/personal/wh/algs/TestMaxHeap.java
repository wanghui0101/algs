package personal.wh.algs;

import org.junit.Test;

import personal.wh.algs.sort.heap.MaxHeap;

public class TestMaxHeap extends TestSupport {

    @Test
    public void testMaxHeapInsert() {
        Integer[] array = generateRandomArray(10, 0, 100);
        MaxHeap<Integer> maxHeap = new MaxHeap<>(10);
        for (Integer e : array) {
            maxHeap.insert(e);
        }
        maxHeap.print();
        
        for (int i = 0; i < 10; i++) {
            System.out.println(maxHeap.extract());
        }
    }
    
}
