package programming2.unit1.BenchmarkingSortingAlgorithms;

import java.util.*;

public class BenchmarkingSortingAlgorithms {
    private int arrSize;
    private long selectionSortRunTime;
    private long arrSortRunTime;

    public BenchmarkingSortingAlgorithms(int arrSize) {
        this.arrSize = arrSize;
    }

    public void run() {
        // Create two arrays of type int[]. Both arrays should be the same size, and the
        // size should be given by a constant in the program so that you can change it
        // easily.
        int[] arr1 = new int[this.arrSize];
        int[] arr2 = new int[this.arrSize];

        // Fill the arrays with random integers. The arrays should have identical
        // contents, with the same random numbers in both arrays. To generate random
        // integers with a wide range of sizes, you could use (int)(Integer.MAX_VALUE *
        // Math.random()).
        for (int i = 0; i < this.arrSize; ++i) {
            int randomInt = (int) (Integer.MAX_VALUE * Math.random());
            arr1[i] = randomInt;
            arr2[i] = randomInt;
        }

        // Time how long it takes to sort the array and print out the time.
        // Sort the first array using Selection Sort.
        long selectionSortStartTime = System.currentTimeMillis();
        selectionSort(arr1);
        this.selectionSortRunTime = System.currentTimeMillis() - selectionSortStartTime;

        // Now, sort the second (identical) array using Arrays.sort(). Again, time how
        // long it takes, and print out the time.
        long arrSortStartTime = System.currentTimeMillis();
        Arrays.sort(arr2);
        this.arrSortRunTime = System.currentTimeMillis() - arrSortStartTime;
    }

    // Print the array size and each time of the sorting method.
    public void printResult() {
        System.out.println("Array size: " + this.arrSize);
        System.out.println("selectionSort(): " + this.selectionSortRunTime + " ms");
        System.out.println("Arrays.sort(): " + this.arrSortRunTime + " ms");
    }

    // You should add the sorting method to your program
    static void selectionSort(int[] A) {
        // Sort A into increasing order, using selection sort

        for (int lastPlace = A.length - 1; lastPlace > 0; lastPlace--) {
            // Find the largest item among A[0], A[1], ...,
            // A[lastPlace], and move it into position lastPlace
            // by swapping it with the number that is currently
            // in position lastPlace.

            int maxLoc = 0; // Location of largest item seen so far.

            for (int j = 1; j <= lastPlace; j++) {
                if (A[j] > A[maxLoc]) {
                    // Since A[j] is bigger than the maximum we've seen
                    // so far, j is the new location of the maximum value
                    // we've seen so far.
                    maxLoc = j;
                }
            }

            int temp = A[maxLoc]; // Swap largest item with A[lastPlace].
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;

        } // end of for loop

    }
}
