package ch01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];   // 栈元素
    private int N = 0;                           // 元素数量

/*
    public ResizingArrayStack(int cap) {
        a = (Item[]) new Object[cap];
    }
*/

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // 将栈移动到一个新的大小为 max 的数组中
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    // 将元素压入栈顶
    public void push(Item item) {
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    // 从栈顶删除元素
    public Item pop() {
        Item item = a[--N];
        a[N] = null;    // 避免对象游离
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // (嵌套类) 支持先进后出的迭代
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            if (i == 0) {
                throw new NoSuchElementException();
            }
            return a[--i];
        }

        @Override
        public void remove() {
            // remove() 方法为空，避免在迭代中穿插能够修改数据结构的操作
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack;
        stack = new ResizingArrayStack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            }
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
