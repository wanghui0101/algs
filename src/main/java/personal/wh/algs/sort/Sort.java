package personal.wh.algs.sort;

public interface Sort {
    
    String getName();
    
    <T extends Comparable<T>> void sort(T[] arr);

}
