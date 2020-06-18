package unionFind;

public class UnionFind3 implements UF {
    private int[] parent;
    private int[] sz; // sz[i]表示以 i 为根的集合中元素个数

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    // 时间复杂度 O{h},h 为树的高度
    public int find(int p) {
        while (p != parent[p]) {
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

        if(sz[pRoot] < sz[qRoot]){
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
