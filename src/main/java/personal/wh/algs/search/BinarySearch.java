package personal.wh.algs.search;

/**
 * 二分查找法
 * 
 * 要求目标数组有序
 * 先与中间元素比较, 目标元素若小于中间元素, 则在左侧区域找
 * 若大于中间元素, 则在右侧区域找
 * 若等于, 则找到
 * 
 * @author wh
 */
public class BinarySearch {

    public <E extends Comparable<E>> int search(E[] arr, E target) {
        int left = 0; // 查找的数组左边界
        int right = arr.length - 1; // 查找的数组右边界
        while (left <= right) {
            //int mid = (left + right) / 2; // !! 可能会出现left+right溢出的问题
            int mid = left + (right - left) / 2; // 中间索引位置
            if (target.equals(arr[mid])) { // 目标元素恰与中间位置元素相同, 则返回此索引
                return mid;
            }
            if (target.compareTo(arr[mid]) < 0) { // 目标元素小于中间位置元素
                right = mid - 1; // 右边界移至中间索引左侧
            } else {
                left = mid + 1; // 左边界移至中间索引右侧
            }
        }
        return -1; // 没有找到, 返回固定值-1
    }

}
