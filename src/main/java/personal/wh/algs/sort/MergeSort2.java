package personal.wh.algs.sort;

import java.util.Arrays;

/**
 * 优化点: 当数据足够小的时候, 插入排序比归并排序的效率要好
 * 
 * @author wh
 * @since 0.0.1
 */
public final class MergeSort2 implements Sort {

    private InsertionSort insertionSort = new InsertionSort();
    
    @Override
    public String getName() {
        return "归并排序(优化版)";
    }

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        mergeSortRecursively(arr, 0, arr.length - 1);
    }
    
    /**
     * 递归归并, 对[begin...end]进行排序
     * @param arr
     * @param begin 
     * @param end
     */
    private <T extends Comparable<T>> void mergeSortRecursively(T[] arr, int begin, int end) {
        if (end - begin <= 15) {
            insertionSort.doSort(arr, begin, end); // 小数组使用插入排序进行优化
            return;
        }
        int mid = (begin + end) / 2;
        mergeSortRecursively(arr, begin, mid); // 左边一半
        mergeSortRecursively(arr, mid + 1, end); // 右边一半
        if (arr[mid].compareTo(arr[mid + 1]) > 0) { // 左右两边并未排好序, 才进行排序
            doMerge(arr, begin, mid, end); // 两半归并
        }
    }
    
    /**
     * 执行归并, 将[begin...mid]和[mid+1...end]进行归并
     * @param arr
     * @param begin
     * @param mid
     * @param end
     */
    private <T extends Comparable<T>> void doMerge(T[] arr, int begin, int mid, int end) {
        T[] auxiliary = Arrays.copyOfRange(arr, begin, end + 1); // 辅助数组, 记录arr中从begin到end的元素值
        
        int i = begin; // 指向左侧数组第1个元素的索引
        int j = mid + 1; // 指向右侧数组第1个元素的索引
        
        for (int k = begin; k <= end; k++) { // 遍历arr中从begin到end的每个元素, 为每个元素设置合适的值
            // 边界判断
            if (i > mid) { // 左侧数组遍历完毕, 只剩右侧数组了. 即此时左侧数组的所有元素都比右侧数组剩下的元素小
                arr[k] = auxiliary[j - begin]; // 放右侧元素
                j++; // 右侧数组元素指针向右移动
            }
            else if (j > end) { // 右侧数组遍历完毕, 只剩左侧数组了. 即此时右侧数组的所有元素都比左侧数组剩下的元素小
                arr[k] = auxiliary[i - begin]; // 放左侧元素
                i++; // 左侧数组元素指针向右移动
            }
            
            // 为什么要减begin? 
            // auxiliary与arr的片段(从begin到end)长度一致, 只不过偏移量为begin
            else if (auxiliary[i - begin].compareTo(auxiliary[j - begin]) < 0) {
                arr[k] = auxiliary[i - begin]; // 选较小的放
                i++; // 左侧数组元素指针向右移动
            } else {
                arr[k] = auxiliary[j - begin]; // 选较小的放
                j++; // 右侧数组元素指针向右移动
            }
        }
    }

}
