package algs;

public class BinaryTree {
    Node root;

    // default access is package-private,
    // which means that all members are visible within the same package
    // but aren't accessible from other packages
    void invert() {
        root = invert(root);
    }

    Node invert(Node node) {
        if (node == null)
            return node;

        /* recursive calls */
        Node left = invert(node.left);
        Node right = invert(node.right);

        /* swap the left and right pointers */
        node.left = right;
        node.right = left;

        return node;
    }

    void print_tree() {
        print_tree(root);
    }

    // print InOrder binary tree traversal
    void print_tree(Node node) {
        if (node == null)
            return;

        print_tree(node.left);
        System.out.println(node.data + " ");

        print_tree(node.right);
    }

    /* testing for example nodes */
    public static void main(String[] args) {
        /* creating a binary tree and entering the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(2);
        tree.root.left = new Node(1);
        tree.root.right = new Node(4);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(5);

        /* print inorder traversal of the input tree */
        System.out.println("InOrder traversal of input tree is: ");
        tree.print_tree();
        System.out.println("");

        /* invert tree */
        tree.invert();

        /* print inorder traversal of the mirror tree */
        System.out.println("InOrder traversal of mirror tree is: ");
        tree.print_tree();

    }
}

// A node contains the value, left and right pointers
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        this.data = item;
        left = right = null;
    }
}