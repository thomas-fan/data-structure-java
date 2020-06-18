package tree;

import set.BSTSet;
import utils.FileOperation;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        testBST();
//        testSegmentTree();
        testTrie();
    }

    private static void testTrie() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            long startTime = System.nanoTime();
            BSTSet<String> set = new BSTSet<>();
            for (String word : words) {
                set.add(word);
            }

            for (String word : words) {
                set.contains(word);
            }

            long endTime = System.nanoTime();
            double result = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + set.getSize());
            System.out.println("BST contains test : " + result + " s");
        }

        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            long startTime = System.nanoTime();
            Trie trie = new Trie();
            for (String word : words) {
                trie.add(word);
            }

            for (String word : words) {
                trie.contains(word);
            }

            long endTime = System.nanoTime();
            double result = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie contains test : " + result + " s");
        }
    }

    private static void testSegmentTree() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> st = new SegmentTree<>(nums, Integer::sum);
//        System.out.println(st);
        System.out.println(st.query(0, 2));
    }

    private static void testBST() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }

        bst.preOrder();
        System.out.println();
        System.out.println(bst);
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();
        bst.levelOrder();
        bst.removeMin();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.removeMax();
        bst.inOrder();
        System.out.println();
        bst.removeMin();
        bst.inOrder();
    }
}
