package ch02;

public class Merge {

    private static Comparable[] aux;        // 归并所需的辅助数组

    // 将数组a[lo..hi]排序
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);                   // 将左半边排序
        sort(a, mid + 1, hi);               // 将右半边排序
        merge(a, lo, mid, hi);              // 归并结果
    }

    // 将 a[lo..mid] 和 a[mid+1..hi] 归并
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi ; k++)     // 将 a[lo..hi] 复制到 aux[lo..hi]
            aux[k] = a[k];

        for (int k = lo; k <= hi ; k++) {   // 归并回到 a[lo..hi]
            if      (i > mid)                   a[k] = aux[j++];    // 左半边用尽，取右半边的元素
            else if (j > hi)                    a[k] = aux[i++];    // 右半边用尽，取左半边的元素
            else if (less(aux[j], aux[i]))      a[k] = aux[j++];    // 右半边的当前元素小于左半边的当前元素，取右半边的元素
            else                                a[k] = aux[i++];    // 右半边的当前元素大于等于左半边的当前元素，取左半边的元素
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
