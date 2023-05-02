package programming2.unit4.NonGradedExercise;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * SetCalculator
 * For this exercise, you should write a program that can be used as a "set
 * calculator" for simple operations on sets of non-negative integers. (Negative
 * integers are not allowed.) A set of such integers will be represented as a
 * list of integers, separated by commas and, optionally, spaces and enclosed in
 * square brackets. For example: [1,2,3] or [17, 42, 9, 53,108]. The characters
 * +, *, and - will be used for the union, intersection, and difference
 * operations. The user of the program will type in lines of input containing
 * two sets, separated by an operator. The program should perform the operation
 * and print the resulting set. Here are some examples:
 *
 * Input Output
 * ------------------------- -------------------
 * [1, 2, 3] + [3, 5, 7] [1, 2, 3, 5, 7]
 * [10,9,8,7] * [2,4,6,8] [8]
 * [ 5, 10, 15, 20 ] - [ 0, 10, 20 ] [5, 15]
 *
 * To represent sets of non-negative integers, use sets of type
 * TreeSet<Integer>. Read the user's input, create two TreeSets, and use the
 * appropriate TreeSet method to perform the requested operation on the two
 * sets. Your program should be able to read and process any number of lines of
 * input. If a line contains a syntax error, your program should not crash. It
 * should report the error and move on to the next line of input. (Note: To
 * print out a Set, A, of Integers, you can just say System.out.println(A).
 * Here, the syntax for sets to be the same as that used by the system for
 * outputting a set.)
 */
public class SetCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            if (parts.length != 3) {
                System.out.println("Syntax error: " + line);
                continue;
            }
            if (!parts[0].startsWith("[") || !parts[0].endsWith("]")) {
                System.out.println("Syntax error: " + line);
                continue;
            }
            if (!parts[2].startsWith("[") || !parts[2].endsWith("]")) {
                System.out.println("Syntax error: " + line);
                continue;
            }

            String operator = parts[1];
            TreeSet<Integer> set1 = buildSet(parts[0]);
            TreeSet<Integer> set2 = buildSet(parts[2]);

            if (set1 == null || set2 == null) {
                System.out.println("Syntax error: " + line);
                continue;
            }

            TreeSet<Integer> result = null;

            if (operator.equals("+")) {
                result = union(set1, set2);
            } else if (operator.equals("*")) {
                result = intersection(set1, set2);
            } else if (operator.equals("-")) {
                result = difference(set1, set2);
            } else {
                System.out.println("Syntax error: " + line);
                continue;
            }

            System.out.println(result);
        }

        sc.close();
    }

    /**
     * Build a TreeSet<Integer> object from a string of a set.
     * The string should be a list of integers, separated by commas
     * and, optionally, spaces and enclosed in square brackets.
     *
     * @param s the string of the set
     * @return a TreeSet<Integer> object, which is the set, or null if there is a
     *         syntax error
     */
    private static TreeSet<Integer> buildSet(String s) {
        try {
            String[] parts = s.substring(1, s.length() - 1).split(",");
            TreeSet<Integer> set = new TreeSet<>();
            for (String part : parts) {
                int n = Integer.parseInt(part.trim());
                if (n < 0) {
                    return null;
                }
                set.add(n);
            }
            return set;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Returns the union of two sets.
     *
     * @param set1 the first set
     * @param set2 the second set
     * @return a TreeSet<Integer> object, which is the union of the two sets
     */
    private static TreeSet<Integer> union(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> result = new TreeSet<>(set1);
        result.addAll(set2);
        return result;
    }

    /**
     * Returns the intersection of two sets.
     *
     * @param set1 the first set
     * @param set2 the second set
     * @return a TreeSet<Integer> object, which is the intersection of the two sets
     */
    private static TreeSet<Integer> intersection(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> result = new TreeSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    /**
     * Returns the difference of two sets.
     *
     * @param set1 the first set
     * @param set2 the second set
     * @return a TreeSet<Integer> object, which is the difference of the two sets
     */
    private static TreeSet<Integer> difference(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> result = new TreeSet<>(set1);
        result.removeAll(set2);
        return result;
    }
}
