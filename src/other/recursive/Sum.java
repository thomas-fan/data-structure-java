package other.recursive;

public class Sum {
    public static int sum(int[] arr) {
        return doSum(arr, 0);
    }

    private static int doSum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }

        return arr[l] + doSum(arr, l + 1);
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(arr));
    }
}
