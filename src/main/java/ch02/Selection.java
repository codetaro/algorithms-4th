package ch02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Selection {

    public static void sort(Comparable[] a) {
        // 算法2.1 选择排序
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // 将a[i]和a[i+1..N]中最小的元素交换
            int min = i;    // 最小元素的索引
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();  // 从标准输入读取字符串
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
