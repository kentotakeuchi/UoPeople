import java.util.*;

public class BinarySearchTree {
    public static void main(String[] args) {
        int iterations = 1; // This variable counts the number of iterations of search that occur
        int[] bTree = new int[50]; // Array to store the binary search tree
        int size = 0; // Current size of the binary search tree

        System.out.println("Enter integers to add to the binary search tree [Enter -1 to stop]:");
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();

        while (value != -1) {
            // Insert the value into the binary search tree
            bTree[size] = value;
            size++;

            // Get the next value from the user
            value = in.nextInt();
        }

        System.out.println("Enter an integer to search for:");
        int searchValue = in.nextInt();

        int idx = size / 2; // Set the initial midpoint of the array which is the root value
        // System.out.println(size);
        // System.out.println(idx);
        // System.out.println(Arrays.toString(bTree));

        while (idx >= 0 && idx < size) {
            if (bTree[idx] == searchValue) {
                System.out.println("Found search value in " + iterations + " iterations.");
                break;
            } else if (searchValue < bTree[idx]) {
                idx = idx / 2; // Search the left branch
            } else {
                idx = (size - idx) / 2 + 1; // Search the right branch
            }
            iterations++;

            // Check if the search value is not present and the index didn't change
            if (idx == size / 2) {
                System.out.println("Search value not found.");
                break;
            }
        }

        if (idx >= 0 && idx < size) {
            System.out.println("Found search value in " + iterations + " iterations");
        } else {
            System.out.println("Search value not found");
        }
    }
}
