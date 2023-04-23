package programming2.unit3.NonGradedExercise;

public class Test {
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

    private static TreeNode root; // Pointer to the root node in the tree.
    // When the tree is empty, root is null.

    /**
     * Return true if item is one of the items in the binary
     * sort tree to which root points. Return false if not.
     */
    static boolean treeContains(TreeNode root, String item) {
        if (root == null) {
            // Tree is empty, so it certainly doesn't contain item.
            return false;
        } else if (item.equals(root.item)) {
            // Yes, the item has been found in the root node.
            return true;
        } else if (item.compareTo(root.item) < 0) {
            // If the item occurs, it must be in the left subtree.
            return treeContains(root.left, item);
        } else {
            // If the item occurs, it must be in the right subtree.
            return treeContains(root.right, item);
        }
    } // end treeContains()

    private static boolean treeContainsNR(TreeNode root, String item) {
        TreeNode runner; // For "running" down the tree.
        runner = root; // Start at the root node.
        while (true) {
            if (runner == null) {
                // We've fallen off the tree without finding item.
                return false;
            } else if (item.equals(runner.item)) {
                // We've found the item.
                return true;
            } else if (item.compareTo(runner.item) < 0) {
                // If the item occurs, it must be in the left subtree.
                // So, advance the runner down one level to the left.
                runner = runner.left;
            } else {
                // If the item occurs, it must be in the right subtree.
                // So, advance the runner down one level to the right.
                runner = runner.right;
            }
        } // end while
    } // end treeContainsNR();

    /**
     * Add the item to the binary sort tree to which the global variable
     * "root" refers. (Note that root can't be passed as a parameter to
     * this routine because the value of root might change, and a change
     * in the value of a formal parameter does not change the actual parameter.)
     */
    private static void treeInsert(String newItem) {
        if (root == null) {
            // The tree is empty. Set root to point to a new node containing
            // the new item. This becomes the only node in the tree.
            root = new TreeNode(newItem);
            return;
        }
        TreeNode runner; // Runs down the tree to find a place for newItem.
        runner = root; // Start at the root.
        while (true) {
            if (newItem.compareTo(runner.item) < 0) {
                // Since the new item is less than the item in runner,
                // it belongs in the left subtree of runner. If there
                // is an open space at runner.left, add a new node there.
                // Otherwise, advance runner down one level to the left.
                if (runner.left == null) {
                    runner.left = new TreeNode(newItem);
                    return; // New item has been added to the tree.
                } else
                    runner = runner.left;
            } else {
                // Since the new item is greater than or equal to the item in
                // runner, it belongs in the right subtree of runner. If there
                // is an open space at runner.right, add a new node there.
                // Otherwise, advance runner down one level to the right.
                if (runner.right == null) {
                    runner.right = new TreeNode(newItem);
                    return; // New item has been added to the tree.
                } else
                    runner = runner.right;
            }
        } // end while
    } // end treeInsert()
}
