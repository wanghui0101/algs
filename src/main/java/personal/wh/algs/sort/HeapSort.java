package personal.wh.algs.sort;

public class HeapSort implements Sort {

    @Override
    public String getName() {
        return "堆排序";
    }

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        MaxHeap<E> maxHeap = new MaxHeap<>(arr.length);
        for (E e : arr) {
            maxHeap.insert(e);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = maxHeap.extract();
        }
    }
    
    private class MaxHeap<E extends Comparable<E>> {

        private Object[] data; // 堆中的元素
        private int capacity; // 堆中的最大元素个数
        private int count; // 堆中现有元素个数
        
        private MaxHeap(int capacity) {
            data = new Object[capacity + 1]; // 为了数据序号与公式对应, 所以索引为0的位置不放元素
            this.capacity = capacity; // 容量
            count = 0; // 初始为0
        }
        
        private int size() {
            return count;
        }
        
        private boolean isEmpty() {
            return size() == 0;
        }
        
        private void insert(E e) {
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
                    i = parentIndex;
                    continue;
                }
                break;
            }
        }
        
        @SuppressWarnings("unchecked")
        private E extract() {
            if (isEmpty()) {
                return null;
            }
            Object root = data[1];
            data[1] = data[count]; // 把第i个元素放到根节点的位置
            count--;
            shiftDown(1);
            return (E) root;
        }
        
        /**
         * 下移元素
         * @param i
         */
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

        /*private void print() {
            for (int i = 1; i < count; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println("\n");
        }*/
        
        private void swap(Object[] arr, int i, int j) {
            Object temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
    }
    
}
