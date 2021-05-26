package ch01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> {
    private Node first; // 指向最早添加的结点的链接
    private Node last;  // 指向最近添加的结点的链接
    private int N;      // 队列中的元素数量

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
//        return N == 0;
    }

    public int size() {
        return N;
    }

    // 向表尾添加元素
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldLast.next = last;
        N++;
    }

    // 从表头删除元素
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    // iterator()

    public static void main(String[] args) {
        // 创建一个队列并操作字符串入列或出列
        Queue<String> q = new Queue<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty())
                StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
