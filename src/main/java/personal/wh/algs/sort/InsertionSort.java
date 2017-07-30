package personal.wh.algs.sort;

/**
 * 算法时间复杂度为 O(n^2)
 * 
 * 思路是(例如从小到大)
 * 1. 从2个元素开始, 依次和其左边的元素进行比较, 比较的结果是使此元素左侧的所有元素都有序
 * 2. 比较时, 如果左侧元素比当前元素还小, 则向右移动, 空位即是插入点
 * 
 * @author wh
 * @since 0.0.1
 */
public class InsertionSort implements Sort {

    @Override
    public String getName() {
        return "插入排序";
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        /*for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    Utils.swap(arr, j, j + 1);
                }
            }
        }*/
        
         /*for (int i = 1; i < arr.length; i++) {
            T e = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j].compareTo(e) > 0) {
                    arr[j + 1] = arr[j];
                    arr[j] = e;
                }
            }
        }*/
        
        /*
         * 记录插入的索引, 做一次性插入
         */
         for (int i = 1; i < arr.length; i++) {
            T e = arr[i];
            int j = i; // 插入的位置
            for (int k = i - 1; k >= 0; k--) {
                if (arr[k].compareTo(e) > 0) {
                    arr[k + 1] = arr[k];
                    j = k;
                }
            }
            arr[j] = e;
        }
    }

}
