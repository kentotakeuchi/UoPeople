import java.util.Scanner;
import java.util.*;

/**
 * BinarySearchTree class.
 */
public class BinarySearchTree_Node {
    /**
     * Node class in a binary search tree.
     */
    public class Node {
        int data;
        Node left;
        Node right;

        /**
         * Constructs a new Node with the given data.
         *
         * @param value the value to be stored in the node
         */
        public Node(int value) {
            data = value;
            left = null;
            right = null;
        }
    }

    Node root;

    /**
     * Constructor.
     */
    public BinarySearchTree_Node() {
        root = null;
    }

    /**
     * Inserts a node with a value into the binary search tree.
     *
     * @param value the value to be inserted
     */
    public void insert(int value) {
        root = insertRecursion(root, value);
    }

    /**
     * Recursively inserts a node with a value into the binary search tree.
     *
     * @param root  the root of the current subtree
     * @param value the value to be inserted
     * @return the updated root of the subtree
     */
    private Node insertRecursion(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.data)
            root.left = insertRecursion(root.left, value);
        else if (value > root.data)
            root.right = insertRecursion(root.right, value);

        return root;
    }

    /**
     * Inorder traversal.
     */
    public void inorderTraversal() {
        inorderRecursion(root);
    }

    /**
     * Inorder traversal with recursion.
     *
     * @param root the root of the current subtree
     */
    private void inorderRecursion(Node root) {
        if (root != null) {
            inorderRecursion(root.left);
            System.out.print(root.data + " ");
            inorderRecursion(root.right);
        }
    }

    /**
     * Preorder traversal.
     */
    public void preorderTraversal() {
        preorderRecursion(root);
    }

    /**
     * Preorder traversal with recursion.
     *
     * @param root the root of the current subtree
     */
    private void preorderRecursion(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRecursion(root.left);
            preorderRecursion(root.right);
        }
    }

    /**
     * Postorder traversal.
     */
    public void postorderTraversal() {
        postorderRecursion(root);
    }

    /**
     * Postorder traversal with recursion.
     *
     * @param root the root of the current subtree
     */
    private void postorderRecursion(Node root) {
        if (root != null) {
            postorderRecursion(root.left);
            postorderRecursion(root.right);
            System.out.print(root.data + " ");
        }
    }

    /**
     * Searches for a value in the binary search tree.
     *
     * @param value the value to be searched
     * @return true if the value is found, false otherwise
     */
    public boolean search(int value) {
        return searchRecursion(root, value);
    }

    /**
     * Searches for a value with recursion.
     *
     * @param root  the root of the current subtree
     * @param value the value to be searched
     * @return true if the value is found, false otherwise
     */
    private boolean searchRecursion(Node root, int value) {
        if (root == null)
            return false;

        if (value == root.data)
            return true;

        if (value < root.data)
            return searchRecursion(root.left, value);

        return searchRecursion(root.right, value);
    }

    /**
     * Main driver.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        BinarySearchTree_Node bst = new BinarySearchTree_Node();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter integers [separated by spaces] to add to the binary search tree: ");
        String input = in.nextLine();
        String[] inputs = input.split(" ");

        for (int i = 0; i < inputs.length; ++i) {
            int num = Integer.parseInt(inputs[i]);
            bst.insert(num);
        }

        System.out.println("Inorder:");
        bst.inorderTraversal();

        System.out.println("\nPreorder:");
        bst.preorderTraversal();

        System.out.println("\nPostorder:");
        bst.postorderTraversal();

        System.out.println("\nEnter an integer to search in the binary search tree: ");
        int searchValue = in.nextInt();
        boolean found = bst.search(searchValue);
        if (found)
            System.out.println("The value " + searchValue + " is found.");
        else
            System.out.println("The value " + searchValue + " is not found.");
    }
}
