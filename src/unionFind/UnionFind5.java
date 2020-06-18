package unionFind;

public class UnionFind5 implements UF {
    private int[] parent;
    private int[] rank; // sz[i]表示以 i 为根的集合的树的高度

    public UnionFind5(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // 时间复杂度 O{h},h 为树的高度
    public int find(int p) {
        while (p != parent[p]) {
            // 路径压缩
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

    // 时间复杂度 O{h},h 为树的高度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }
        else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        }
        else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
