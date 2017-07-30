package personal.wh.algs.sort;

/**
 * 算法时间复杂度为 O(nlogn)
 * 
 * 利用插入排序算法的思想, 以步长递减的排序方式进行了优化
 * 
 * 思路是(例如从小到大)
 * 1. 设置一个步长, 通常为元素个数的一半
 * 2. 按步长间隔, 从第2个元素开始, 依次和其左边的元素进行比较, 比较的结果是使此元素左侧的所有元素都有序
 * 3. 比较时, 如果左侧元素比当前元素还小, 则向右移动, 空位即是插入点
 * 4. 取步长的一半作为新的步长, 重复以上操作, 直至步长为1
 * 
 * @author wh
 * @since 0.0.1
 */
public class ShellSort implements Sort {

    @Override
    public String getName() {
        return "希尔排序";
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        int step = arr.length / 2;
        while (step >= 1) {
            for (int i = step; i < arr.length; i++) {
                T e = arr[i];
                int j = i; // 插入的位置
                for (int k = i - step; k >= 0; k -= step) {
                    if (arr[k].compareTo(e) > 0) {
                        arr[k + step] = arr[k];
                        j = k;
                    }
                }
                arr[j] = e;
            }
            step /= 2;
        }
    }
    
}
