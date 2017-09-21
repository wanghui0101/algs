package personal.wh.algs.sort;

import java.util.Random;

/**
 * 时间复杂度 O(nlogn)
 * 
 * 思路是(例如从小到大)
 * 1. 随机找一个元素
 * 2. 将数组划分为2个区, 元素左边都是比它小的, 元素右边都是比它大的, 那么此时元素的位置就是最终排好序的位置
 * 3. 再对左右两区应用以上逻辑, 直至所有元素都找到自己的位置
 * 
 * 快速排序是对冒泡排序的改进, 只不过它的做法是找一个元素, 比它大的下沉到左边, 比它大的上浮到右边
 * 
 * @author wh
 * @since 0.0.1
 */
public final class QuickSort implements Sort {

    private InsertionSort insertionSort = new InsertionSort();
    
    @Override
    public String getName() {
        return "快速排序";
    }

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        quickSortRecursively(arr, 0, arr.length - 1);
    }

    private <E extends Comparable<E>> void quickSortRecursively(E[] arr, int begin, int end) {
        if (end - begin <= 15) {
            insertionSort.doSort(arr, begin, end);
            return;
        }
        int p = partition(arr, begin, end);
        quickSortRecursively(arr, begin, p - 1);
        quickSortRecursively(arr, p + 1, end);
    }
    
    /**
     * 在begin与end之间随机找一个数, 并使得数组中所有小于此数的数据都在此数左边, 所有大于此数的数据都在此数右边, 
     * 最终返回此数的索引
     * 
     * 经过上述逻辑处理后, 此随机数就是其全部排序后的最终位置
     * 
     * |v|     <v     |     >v     |
     * 
     *      交换v与<v部分的最后一位 ↓
     *            
     * |      <v    |v|     >v     |
     * 
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    private <T extends Comparable<T>> int partition(T[] arr, int begin, int end) {
        // 为什么使用随机值? 随机值使得数组分隔为2部分的概率更大
        int randomIndex = new Random().nextInt(end - begin + 1) + begin; // 在begin和end之间选一个随机索引
        swap(arr, begin, randomIndex); // 交换随机索引和begin元素的值
        T v = arr[begin]; // 随机索引值
        
        int p = begin; // 指向v应最终交换的位置, 即v左侧比v小的部分中的最后一位
        for (int i = p + 1; i <= end; i++) { // 从第2个元素开始遍历
            if (arr[i].compareTo(v) < 0) { // 如果当前元素比v小
                swap(arr, i, p + 1); // 那么将当前元素与比v大的部分的第1个元素交换
                p++; // 同时指针后移1位
            }
        } // for循环执行完毕的结果是 v、<v、>v 3部分, j指向 <v 部分的最后一个元素
        swap(arr, begin, p); // 交换begin的p的位置, 使数组形成 <v、v、>v 3部分
        return p;
    } 
}
