package personal.wh.algs.sort;

public interface Sort {
    
    String getName();
    
    <E extends Comparable<E>> void sort(E[] arr);
    
    default <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
