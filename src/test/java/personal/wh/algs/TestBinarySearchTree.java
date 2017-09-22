package personal.wh.algs;

import org.junit.Test;

import personal.wh.algs.search.BinarySearchTree;

public class TestBinarySearchTree {

    @Test
    public void test() {
        String text = "wroeiwhojvabvbarbvaugbvaeuigbueaogiebgi";
        
        BinarySearchTree<String, Integer> binarySearchTree = new BinarySearchTree<>();
        
        for (int i = 0; i < text.length(); i++) {
            String s = String.valueOf(text.charAt(i));
            Integer count = binarySearchTree.search(s);
            if (count != null) {
                binarySearchTree.insert(s, count + 1);
            } else {
                binarySearchTree.insert(s, 1);
            }
        }
        
        System.out.println(binarySearchTree.search("a"));
        
        binarySearchTree.preOrder();
        System.out.println();
        
        binarySearchTree.inOrder(); // 中序遍历二分搜索树可以得到顺序的节点
        System.out.println();
        
        binarySearchTree.postOrder();
        System.out.println();
        
        binarySearchTree.levelOrder();
    }
    
    @Test
    public void test2() {
        int[] arr = new int[] {41, 22, 58, 15, 33, 50, 13, 37, 42, 53};
        
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<>();
        
        for (int i = 0; i < arr.length; i++) {
            binarySearchTree.insert(arr[i], i);
        }
        
        //System.out.println(binarySearchTree.search("a"));
        
        binarySearchTree.preOrder();
        System.out.println();
        
        binarySearchTree.inOrder(); // 中序遍历二分搜索树可以得到顺序的节点
        System.out.println();
        
        binarySearchTree.postOrder();
        System.out.println();
        
        binarySearchTree.levelOrder();
    }
    
}
