package personal.wh.algs.sort;

import personal.wh.algs.sort.util.Utils;

/**
 * 算法时间复杂度为 O(n^2)
 * 
 * 思路是(例如从小到大)
 * 1. 每趟都找出本趟最大的一个并放置到最右侧
 * 2. 每趟找时, 相邻的2个元素进行比较, 将较大的放到右侧
 * 
 * @author wh
 * @since 0.0.1
 */
public class BubbleSort implements Sort {

    @Override
    public String getName() {
        return "冒泡排序";
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    Utils.swap(arr, j, j + 1);
                }
            }
        }
    }

}
