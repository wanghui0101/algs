package personal.wh.algs.sort.heap;

/**
 * 关于树的基础知识
 * 
 * http://www.cnblogs.com/idorax/p/6441043.html
 * 
 * 二叉树(Binary Tree)：每个结点至多拥有两棵子树(即二叉树中不存在度大于2的结点)，并且，二叉树的子树有左右之分，其次序不能任意颠倒。
 * 
 * 完美二叉树(Perfect Binary Tree)：除叶子节点外，所有节点都有2个子节点
 * 
 * 完全二叉树(Complete Binary Tree)：倒数第2层符合完美二叉树, 最后一层左右子节点靠左
 * 
 * 完满二叉树(Full Binary Tree)：除叶子节点外，所有节点如果有子节点，就必须是2个子节点
 * 
 * ------------------------------------------------------------------------------------
 * 
 * 最大堆在满足完全二叉树的数据结构的基础上，对于节点中的数值，需保证所有父节点的数值都要比子节点大
 * 
 * 这样根节点的数值永远是所有数据中最大的，取出根节点后，需要调整最大堆的结构，使其仍满足完全二叉树
 * 
 * 这样，如果连续取根节点的值，那么就可以实现一组数据从大到小排列
 * 
 * 使用堆排序的时间复杂度是O(nlogn)
 * 
 * ------------------------------------------------------------------------------------
 * 
 * 一个满足完全二叉树的最大堆的示例
 * 
 *            62
 *       /         \
 *      41         30
 *    /    \     /   \
 *   28    16   22   13
 *  /  \  /
 * 19 17 15
 * 
 * 如按从上到下，从左到右的顺序标记序号
 * 
 *                    62(1)
 *              /             \
 *           41(2)           30(3)
 *       /         \         /   \
 *     28(4)     16(5)   22(6) 13(7)
 *  /      \      /
 * 19(8) 17(9) 15(10)
 * 
 * 可以发现：
 * 若记某节点序号为i,
 * 左孩子序号为 2i
 * 右孩子需要为 2i + 1
 * 父节点序号为 i / 2
 * 
 * @author wh
 *
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {

    private Object[] data; // 堆中的元素
    private int capacity; // 堆中的最大元素个数
    private int count; // 堆中现有元素个数
    
    public MaxHeap(int capacity) {
        data = new Object[capacity + 1]; // 为了数据序号与公式对应, 所以索引为0的位置不放元素
        this.capacity = capacity; // 容量
        count = 0; // 初始为0
    }
    
    public int size() {
        return count;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public void insert(E e) {
        assert count + 1 <= capacity;
        
        data[++count] = e; // 将新插入的元素放在数组的最后一位
        shiftUp(count);
    }

    /**
     * 上移元素
     * @param i
     */
    @SuppressWarnings("unchecked")
    private void shiftUp(int i) {
        while (i > 1) {
            int parentIndex = i / 2; // 父元素索引
            E parent = (E) data[parentIndex]; // 父元素
            E element = (E) data[i]; // 当前元素
            if (element.compareTo(parent) > 0) { // 当前元素比父元素还大
                swap(data, i, parentIndex); // 与父元素交换位置
                i = parentIndex; // 
                continue;
            }
            break;
        }
    }
    
    @SuppressWarnings("unchecked")
    public E extract() {
        if (isEmpty()) {
            return null;
        }
        Object root = data[1];
        data[1] = data[count]; // 把第i个元素放到根节点的位置
        count--;
        shiftDown(1);
        return (E) root;
    }
    
    @SuppressWarnings("unchecked")
    private void shiftDown(int i) {
        E element = (E) data[i];
        while (2 * i <= count) { // 一定有子节点(至少有左孩子)
            int j = 2 * i; // 孩子中较大值的索引
            E leftChild = (E) data[j]; // 左孩子的值
            int k = j + 1; // 右孩子索引
            if (k <= count) { // 是否有右孩子
                E rightChild = (E) data[k]; // 右孩子值
                if (leftChild.compareTo(rightChild) < 0) {
                    j = k; // 右孩子比左孩子还大, j的值指向右孩子节点
                }
            }
            E biggerChild = (E) data[j];
            if (element.compareTo(biggerChild) < 0) { // 孩子比父节点还大
                swap(data, i, j); // 交换位置
                i = j;
                continue;
            }
            break;
        }
    }

    public void print() {
        for (int i = 1; i < count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("\n");
    }
    
    private void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
