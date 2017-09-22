package personal.wh.algs.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树
 * 
 * 特点：
 * 1. 是一棵二叉树
 * 2. 父节点的值比左孩子大, 比右孩子小
 * 
 * 举例：
 * 
 *        41
 *     /     \
 *   22       58
 *   / \      /
 *  15 33    50
 *  /   \   /  \
 * 13   37 42  53
 * 
 * 例如：插入元素为60, 依次比较 41-58，插入58的右孩子位置
 * 例如：插入元素为28，依次比较 41-22-33，插入33的左孩子位置
 * 例如：插入元素为42，依次比较 41-58-50-42，覆盖42的值
 * 
 * 
 * 查找：O(logn)
 * 插入：O(logn)
 * 删除：O(logn)
 * 
 * @author wh
 *
 * @param <K>
 * @param <V>
 */
public class BinarySearchTree<K extends Comparable<K>, V> {

    /**
     * 代表树的一个节点
     */
    private class Node {
        private K key; // 节点的key
        private V value; // 节点的value
        private Node leftChild; // 节点的左孩子
        private Node rightChild; // 节点的右孩子
        
        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Node root;
    private int count = 0; // 树的节点数
    
    /**
     * 插入一个key-value
     * 
     * @param key
     * @param value
     */
    public void insert(K key, V value) {
        root = insert(root, key, value);
    }
    
    /**
     * 向以node节点为根的二叉搜索树中插入key-value
     * @param node
     * @param key
     * @param value
     * @return 插入的新节点的node节点
     */
    private Node insert(Node node, K key, V value) {
        if (node == null) { // 如果node为空, 则新建一个节点
            count++; // 节点数+1
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) { // key比当前节点的key小
            node.leftChild = insert(node.leftChild, key, value); // 向左孩子为根的二叉搜索树中插入
        } else if (key.compareTo(node.key) > 0) { // key比当前节点的key大
            node.rightChild = insert(node.rightChild, key, value); // 向右孩子为根的二叉搜索树中插入
        } else { // key与当前节点相等
            node.value = value; // value覆盖原值
        }
        return node;
    }
    
    public boolean contains(K key) {
        return contains(root, key);
    }
    
    /**
     * 向以node节点为根的二叉搜索树中查找key
     * @param node
     * @param key
     * @return
     */
    private boolean contains(Node node, K key) {
        if (node == null) { // 如果node为空, 则没有找到
            return false;
        }
        if (key.compareTo(node.key) < 0) { // key比当前节点的key小
            return contains(node.leftChild, key); // 向左孩子为根的二叉搜索树中查找
        } else if (key.compareTo(node.key) > 0) { // key比当前节点的key大
            return contains(node.rightChild, key); // 向右孩子为根的二叉搜索树中查找
        }
        return true; // key与当前节点相等
    }
    
    public V search(K key) {
        return search(root, key);
    }

    /**
     * 向以node节点为根的二叉搜索树中查找key
     * @param node
     * @param key
     * @return
     */
    private V search(Node node, K key) {
        if (node == null) { // 如果node为空, 则没有找到
            return null;
        }
        if (key.compareTo(node.key) < 0) { // key比当前节点的key小
            return search(node.leftChild, key); // 向左孩子为根的二叉搜索树中查找
        } else if (key.compareTo(node.key) > 0) { // key比当前节点的key大
            return search(node.rightChild, key); // 向右孩子为根的二叉搜索树中查找
        }
        return node.value; // key与当前节点相等
    }
    
    public void preOrder() {
        preOrder(root);
    }
    
    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " "); // 先打印
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    public void inOrder() {
        inOrder(root);
    }
    
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.print(node.key + " "); // 中间打印
            inOrder(node.rightChild);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.print(node.key + " "); // 后打印
        }
    }

    private Queue<Node> q = new LinkedList<>(); // 辅助层序遍历的队列
    
    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(Node node) {
        q.offer(node); // 放入节点
        while (!q.isEmpty()) {
            Node _node = q.poll(); // 弹出节点
            System.out.print(_node.key + " "); // 打印
            if (_node.leftChild != null) { // 左孩子不为空
                q.offer(_node.leftChild); // 放入左孩子
            }
            if (_node.rightChild != null) { // 右孩子不为空
                q.offer(_node.rightChild); // 放入右孩子
            }
        }
    }
    
    public K searchMin() {
        if (count > 0) {
            Node minNode = searchMin(root);
            return minNode.key;
        }
        return null;
    }
    
    /**
     * 从根节点开始, 一直找左孩子的左孩子, 那么最后一个没有左孩子的节点就是最小的
     * @param node
     * @return
     */
    private Node searchMin(Node node) {
        Node leftChild = node.leftChild;
        if (leftChild != null) { // 还有左孩子接着找
            return searchMin(leftChild);
        }
        return node; // 没有左孩子, 即是最小节点
    }
    
    public K searchMax() {
        if (count > 0) {
            Node maxNode = searchMax(root);
            return maxNode.key;
        }
        return null;
    }
    
    /**
     * 从根节点开始, 一直找右孩子的右孩子, 那么最后一个没有右孩子的节点就是最大的
     * @param node
     * @return
     */
    private Node searchMax(Node node) {
        Node rightChild = node.rightChild;
        if (rightChild != null) { // 还有右孩子接着找
            return searchMax(rightChild);
        }
        return node; // 没有右孩子, 即是最大节点
    }
    
    public void removeMin() {
        if (count > 0) {
            root = removeMin(root);
        }
    }

    /**
     * 从根节点开始, 一直找左孩子的左孩子, 那么最后一个没有左孩子的节点就是最小的
     * 
     * @param node 以此节点为根找左孩子
     * @return 此根节点
     */
    private Node removeMin(Node node) {
        Node leftChild = node.leftChild;
        if (leftChild != null) { // 还有左孩子, 接着找
            node.leftChild = removeMin(leftChild);
        }
        return node.rightChild; // 需要删除node, 删除的方式是使用其右孩子代替此node
    }
    
    public void removeMax() {
        if (count > 0) {
            root = removeMax(root);
        }
    }

    /**
     * 从根节点开始, 一直找右孩子的右孩子, 那么最后一个没有右孩子的节点就是最大的
     * 
     * @param node 以此节点为根找左孩子
     * @return 此根节点
     */
    private Node removeMax(Node node) {
        Node rightChild = node.rightChild;
        if (rightChild != null) { // 还有右孩子, 接着找
            node.rightChild = removeMax(rightChild);
        }
        return node.leftChild; // 需要删除node, 删除的方式是使用其左孩子代替此node
    }
}
