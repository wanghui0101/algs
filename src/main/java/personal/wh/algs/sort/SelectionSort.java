package personal.wh.algs.sort;

import personal.wh.algs.sort.util.Utils;

/**
 * 算法时间复杂度为 O(n^2)
 * 
 * 思路是(例如从小到大)
 * 1. 每趟都找出本趟最小的一个并放置到最左侧
 * 2. 每趟找时, 找到最小值的索引, 最后与最左侧元素交换位置
 * 
 * @author wh
 * @since 0.0.1
 */
public class SelectionSort implements Sort {
    
    @Override
    public String getName() {
        return "选择排序";
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Utils.swap(arr, i, minIndex);
        }
    }

}
