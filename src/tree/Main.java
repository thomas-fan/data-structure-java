package tree;

import set.BSTSet;
import utils.FileOperation;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        testBST();
//        testSegmentTree();
//        testTrie();
        testAVLTree();
    }

    private static void testAVLTree() {
        String filename = "pride-and-prejudice.txt";
        AVLTree<String, Integer> map = new AVLTree<>();
        long startTime = System.nanoTime();
        System.out.println(filename);
        ArrayList<String > words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
            for (String word: words) {
                if(map.contains(word) ) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
        long endTime = System.nanoTime();
        double second = (endTime - startTime) / 1000000000.0;
        System.out.println("Cost time: " + second + "s");
        System.out.println("Is balanced " + map.isBalanced());
        System.out.println("Is BST " + map.isBST());
        for (String word: words) {
            map.remove(word);
            if (!map.isBST() || !map.isBalanced()) {
                throw new RuntimeException("Error");
            }
        }
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
