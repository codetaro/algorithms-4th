package ch01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * The {@code StaticSETofInts} class represents a set of integers.
 * It supports searching for a given integer is in the set. It accomplishes
 * this by keeping the set of integers in a sorted array and using
 * binary search to find the given integer.
 * <p>
 *     The <em>rank</em> and <em>contains</em> operations take
 *     logarithmic time in the worst case.
 * <p>
 *     For additional documentation, see <a href="https://algs4.cs.princeton.edu/12oop">Section 1.2</a> of
 *     <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class StaticSETofInts {
    private int[] a;

    public StaticSETofInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            // 保护性复制
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    private int rank(int key) {
        // 二分查找
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // 键要么存在于a[lo..hi]中，要么不存在
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] w = In.readInts(args[0]);
        StaticSETofInts set = new StaticSETofInts(w);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (!set.contains(key)) {
                StdOut.println(key);
            }
        }
    }
}
