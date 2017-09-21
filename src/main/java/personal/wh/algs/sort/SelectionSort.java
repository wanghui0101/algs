package personal.wh.algs.sort;

/**
 * 算法时间复杂度为 O(n^2)
 * 
 * 思路是(例如从小到大)
 * 1. 每趟都找出本趟最小的一个并放置到最左侧
 * 2. 每趟找时, 找到最小值的索引, 最后与最左侧元素交换位置
 * 
 * 优点：
 * 容易理解
 * 
 * 缺点：
 * 遍历的次数是一定的, 不能提前结束, 因此效率一般
 * 
 * 与冒泡排序相比：
 * 交换次数少, 每趟只是找最小值的索引, 只交换一次即可
 * 
 * @author wh
 * @since 0.0.1
 */
public final class SelectionSort implements Sort {
    
    @Override
    public String getName() {
        return "选择排序";
    }

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i; // 每趟的最小值索引
            for (int j = i + 1; j < arr.length; j++) { // 从左向右找
                if (arr[j].compareTo(arr[minIndex]) < 0) { // 如果某元素比最小的元素还小
                    minIndex = j; // 记录这个更小元素的索引
                }
            }
            swap(arr, i, minIndex); // 把最小值放到最左边
        }
    }

}
