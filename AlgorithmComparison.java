
// import Prog1Tools.IOTools;
import java.util.*;

public class BtreeAlgorithm {
    public static class btreeNode {
        btreeNode left;
        btreeNode right;
        int value;

        public btreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        btreeNode link, root;
        int treeValue;
        int searchValue;
        int iterations;
        iterations = 0;
        root = null;
        link = null;
        Scanner in = new Scanner(System.in);
        // build binary tree, add node
        do {
            System.out.println("Enter value to populate tree with: ");
            treeValue = in.nextInt();
            if (treeValue > 0) {
                if (root != null) {
                    addNode(root, treeValue);
                } else {
                    root = new btreeNode(treeValue);
                }
            }
        } while (treeValue > 0);
        System.out.println("Enter search value : ");
        searchValue = in.nextInt();
        iterations = findNode(root, searchValue, iterations);
        if (iterations == 0) {
            System.out.println("Search value not found");
        } else {
            System.out.println("Value found in " + iterations + " iterations");
        }
    }

    // Value search
    public static int findNode(btreeNode node, int value, int iter) {
        if (node != null) {
            if (value == node.value) {
                iter += 1;
            } else if (value < node.value) {
                iter += 1;
                iter = findNode(node.left, value, iter);

            } else {
                iter += 1;
                iter = findNode(node.right, value, iter);
            }
        }
        return (iter);
    }

    // Search tree node add
    public static void addNode(btreeNode node, int value) {
        btreeNode pnode;
        pnode = null;
        if (value < node.value) {
            if (node.left != null) {
                addNode(node.left, value);
            } else {
                System.out.println(" Inserted " + value + " to left of " +
                        node.value);
                node.left = new btreeNode(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                addNode(node.right, value);
            } else {
                System.out.println(" Inserted " + value + " to right of " +
                        node.value);
                node.right = new btreeNode(value);

            }
        }
    }
}