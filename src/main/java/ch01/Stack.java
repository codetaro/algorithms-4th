package ch01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> {
    private Node first; // 栈顶（最近添加的元素）
    private int N;      // 元素数量

    // 定义了结点的嵌套类
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

    // 向栈顶添加元素
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    // 从栈顶删除元素
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    // iterator()

    public static void main(String[] args) {
        // 创建一个栈并根据StdIn中的指示压入或弹出字符串
        Stack<String> s = new Stack<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
