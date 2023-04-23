package programming2.unit3.NonGradedExercise;

/**
 * This program creates a random binary sort tree with 1023 nodes and display
 * the
 * average and maximum depth of its leaves on the console.
 */
public class RandomBinarySortTree {

    /**
     * An object of type TreeNode represents one node in a binary tree of strings.
     */
    private static class TreeNode {
        String item; // The data in this node.
        TreeNode left; // Pointer to left subtree.
        TreeNode right; // Pointer to right subtree.

        TreeNode(String str) {
            // Constructor. Make a node containing str.
            // Note that left and right pointers are null.
            item = str;
        }
    } // end class TreeNode

    /**
     * Insert a new TreeNode with the given item into the given random binary sort
     * tree,
     * if the item is not already in the tree.
     */
    public static TreeNode treeInsert(TreeNode root, String newItem) {
        if (root == null) {
            return new TreeNode(newItem);
        }
        int comparison = newItem.compareTo(root.item);
        if (comparison < 0) {
            root.left = treeInsert(root.left, newItem);
        } else if (comparison > 0) {
            root.right = treeInsert(root.right, newItem);
        }
        return root;
    }

    /**
     * Count the number of leaves in the given random binary sort tree.
     */
    public static int countLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }

    /**
     * Sum the depths of all the leaves in the given random binary sort tree.
     */
    public static int sumLeafDepths(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return depth;
        }
        return sumLeafDepths(node.left, depth + 1) + sumLeafDepths(node.right, depth + 1);
    }

    /**
     * Return the maximum depth among all the leaves in the given random binary sort
     * tree.
     */
    public static int maxLeafDepth(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return depth;
        }
        return Math.max(maxLeafDepth(node.left, depth + 1), maxLeafDepth(node.right, depth + 1));
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int numNodes = 1023;

        for (int i = 0; i < numNodes; i++) {
            double randomValue = Math.random();
            String stringValue = String.valueOf(randomValue);
            root = treeInsert(root, stringValue);
        }

        int leafCount = countLeaves(root);
        int totalLeafDepth = sumLeafDepths(root, 0);
        int maxLeafDepth = maxLeafDepth(root, 0);

        double averageLeafDepth = (double) totalLeafDepth / leafCount;

        System.out.println("Average leaf depth: " + averageLeafDepth);
        System.out.println("Maximum leaf depth: " + maxLeafDepth);
    }
}
