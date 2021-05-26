package ch01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class TwoSumFast {

    // 计算和为0的整数对的数目
    public static int count(int[] a) {
        // 将数组排序（为二分查找做准备）
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            if (BinarySearch.rank(-a[i], a) > i) {
                // 如果二分查找不成功则会返回-1
                // 如果二分查找返回的j在0和i之间，不能增加计数器的值，以避免重复计数
                cnt++;
            }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
