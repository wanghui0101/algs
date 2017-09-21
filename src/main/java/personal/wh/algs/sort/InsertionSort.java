package personal.wh.algs.sort;

/**
 * 算法时间复杂度为 O(n^2)
 * 
 * 思路是(例如从小到大)
 * 1. 从2个元素开始, 依次和其左边的元素进行比较, 比较的结果是使此元素左侧的所有元素都有序
 * 2. 比较时, 如果左侧元素比当前元素还小, 则向右移动, 空位即是插入点
 * 
 * 优点：
 * 对于基本顺序(数组顺序与目标序相同)的数组比较和移动次数很少, 效率很高
 * 
 * 缺点:
 * 对于基本逆序(数组顺序与目标序相逆)的数组比较和移动次数很多, 效率不高
 * 
 * 针对其缺点, 希尔排序进行了优化
 * 
 * @author wh
 * @since 0.0.1
 */
public final class InsertionSort implements Sort {

    @Override
    public String getName() {
        return "插入排序";
    }

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        doSort(arr, 0, arr.length - 1);
    }
    
    protected <T extends Comparable<T>> void doSort(T[] arr, int begin, int end) {
        // 从第2个元素开始, 与它之前的元素做比较
        for (int i = begin + 1; i <= end; i++) {
           // 目标数据, 就是要为这个数据向前(左侧)找一个适合的位置插入进去
           // 所谓合适的位置, 就是后面的元素比它大, 前面的元素比它小
           T e = arr[i]; 
           int j = i; // 当前的位置为默认的插入的位置
           // 接下来就是找合适的位置的过程
           for (int k = i - 1; k >= begin; k--) { // 从目标数据的前1个数据到数组的第1个数据依次比较
               if (arr[k].compareTo(e) > 0) { // 如果前面(左侧)某元素比目标元素还大, 就, 
                   arr[k + 1] = arr[k]; // 向后(右侧)移动一位
                   j = k; // 空出自己原来的位置, 即是要插入目标元素的位置
               }
           }
           arr[j] = e; // 插入目标元素
       }
    }

}
