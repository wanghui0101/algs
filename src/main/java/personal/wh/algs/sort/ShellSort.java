package personal.wh.algs.sort;

/**
 * 算法时间复杂度为O(n*log2n)
 * 
 * 利用插入排序算法的思想, 以步长递减的排序方式进行了优化
 * 
 * 思路是(例如从小到大)
 * 1. 设置一个步长, 通常为元素个数的一半
 * 2. 按步长间隔, 从第2个元素开始, 依次和其左边的元素进行比较, 比较的结果是使此元素左侧的所有元素都有序
 * 3. 比较时, 如果左侧元素比当前元素还小, 则向右移动, 空位即是插入点
 * 4. 取步长的一半作为新的步长, 重复以上操作, 直至步长为1
 * 
 * 对插入排序进行的优化体现在: 
 * 若数组有基本逆序, 则最后的元素想要移动到前面需要做大量的比较和移动, 如果根据步长进行分组, 则可以减少这个过程
 * 
 * @author wh
 * @since 0.0.1
 */
public final class ShellSort implements Sort {

    @Override
    public String getName() {
        return "希尔排序";
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        doSort(arr, 0, arr.length - 1);
    }
    
    protected <T extends Comparable<T>> void doSort(T[] arr, int begin, int end) {
     // 初始以数组的一半长度作为步长
        // 步长为1时结束排序
        // 每次步长减半
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i <= end; i++) { // 第1组的第2个元素是索引为step的元素
                T e = arr[i]; // 目标数据, 即要为此元素向前按照step步长找到合适的插入位置
                int j = i; // 当前的位置为默认的插入的位置
                for (int k = i - step; k >= begin; k -= step) { // 按step步长向前找
                    if (arr[k].compareTo(e) > 0) { // 前面的某个元素比目标元素大
                        arr[k + step] = arr[k]; // 此元素后移step位
                        j = k; // 空出自己原来的位置, 即是要插入目标元素的位置
                    }
                }
                arr[j] = e; // 插入目标元素
            }
        }
    }
    
}
