package tree;

public class Main {
    public static void main(String[] args) {
//        testBST();
        testSegmentTree();
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
