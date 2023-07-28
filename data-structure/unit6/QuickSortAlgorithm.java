import jeliot.io.*;
import java.util.*;

public class QuickSortAlgorithm {
    private int arr[];
    private int len;
    public static int c = 0;

    public void sort(int[] inArr) {

        if (inArr == null || inArr.length == 0) {
            return;
        }
        this.arr = inArr;
        len = inArr.length;
        qSort(0, len - 1); // call qSort with lower and upper index
    }

    private void qSort(int bottomIdx, int topIdx) {
        int b = bottomIdx;
        int t = topIdx;
        // determine the pivot point as the middle index
        int pvt = arr[bottomIdx + (topIdx - bottomIdx) / 2]; // pick pivot value from center
        // divide into two arrays using pivot point
        while (b <= t) { // find number in left that is greater than the
                         // value in the pivot position and find number in right
                         // that is less than pivot value. When two values are
                         // found, switch the number with each other.
            while (arr[b] < pvt) {
                b++; // when index is less than pivot point, increment by 1
            }
            while (arr[t] > pvt) {
                t--; // when index is greater than pivot point, decrement by 1
            }
            if (b <= t) {
                exchElements(b, t); // if b <= t, increment or decrement index
                b++;
                t--;
            }
        }
        // call qSort() recursively using the current value of t
        if (bottomIdx < t) {
            qSort(bottomIdx, t);
        }
        // call qSort() recursively using the current value of b
        if (b < topIdx) {
            qSort(b, topIdx);
        }
    }

    // function to swap the two values
    private void exchElements(int b, int t) {
        // Increment exchange count when values are not equal & exchange values
        if (b != t) {
            System.out.println(" Exch values:  " + arr[b] + " and " + arr[t]);
            c++;
            int temp = arr[b];
            arr[b] = arr[t];
            arr[t] = temp;
        }
    }

    public static void main(String a[]) {
        QuickSortAlgorithm sorter = new QuickSortAlgorithm();
        // Unsorted Input
        int[] input = { 12, 9, 4, 99, 120, 1, 3, 10, 23, 45, 75, 69, 31, 88, 101, 14, 29, 91, 2, 0, 77 };
        // Sorted Input
        // int[] input = {0,1,2,3,4,9,10,12,14,23,29,31,45,69,75,77,88,91,99,101,120};
        // Reverse Sorted input
        // int[] input = {120,101,99,91,88,77,75,69,45,31,29,23,14,12,10,9,4,3,2,1,0};
        System.out.println("\n>> Quick Sort Input <<");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(" ");
        }
        System.out.println("\n");
        // Sort Input array
        sorter.sort(input);
        // Display sorted results
        System.out.println("\n\n>> Quick Sort Sorted output <<");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(" ");
        }
        System.out.println("\n\n Value Exchange occurred " + c + " times");
    }
}