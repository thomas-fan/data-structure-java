package unionFind;

import java.util.Random;

public class Main {
    private static double testUf(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();
        long starTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();
        return (endTime - starTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 100000;
        int m = 100000;
        UnionFind1 uf1 = new UnionFind1(size);
        System.out.println("UnionFind1 : " + testUf(uf1, m) + " s");
        UnionFind2 uf2 = new UnionFind2(size);
        System.out.println("UnionFind2 : " + testUf(uf2, m) + " s");
    }
}
