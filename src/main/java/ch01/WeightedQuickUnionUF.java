package ch01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * union-find 算法
 */
public class WeightedQuickUnionUF {
    private int[] id;   // 分量id（以触点作为索引）
    private int[] sz;   // 各个根节点所对应分量的大小
    private int count;  // 分量数量

    // 以整数标识（0 到 N-1）初始化N个触点
    public WeightedQuickUnionUF(int N) {
        count = N;

        // 初始化分量id数组
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;

        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    // 在 p 和 q 之间添加一条连接
    void union(int p, int q) {
/*
        请见
        quick-find              ~ N^2
        quick-union             ~ (2N-1, N^2)
        weighted-quick-union    ~ logN
*/
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;
        // 将小树的根节点连接到大树的根节点
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }

    // p 所在的分量的标识符(0 到 N-1)
    public int find(int p) {
        // union()方法必须保证 -- 对于处在同一个连通分量中的触点均返回相同的整数值
        while (p != id[p]) p = id[p];
        return p;
    }

    // 如果 p 和 q 存在于同一个分量中则返回true
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // 连通分量的数量
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;   // 如果已经连通则忽略
            uf.union(p, q);                     // 归并分量
            StdOut.println(p + " " + q);        // 打印连接
        }
        StdOut.println(uf.count() + " components");
    }
}
