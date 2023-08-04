public class QuickSortCode {

    static int exchangeCount = 0;

    static int partition(int array[], int low, int high) {

        // select pivot

        int pivot = array[high];

        int i = (low - 1);

        for (int j = low; j < high; j++) {

            if (array[j] < pivot) {

                i++;

                // exchange

                int temp = array[i];

                array[i] = array[j];

                array[j] = temp;

                exchangeCount++;

            }

        }

        // exchange

        int temp = array[i + 1];

        array[i + 1] = array[high];

        array[high] = temp;

        exchangeCount++;

        return i + 1;

    }

    static void quickSort(int array[], int low, int high) {

        if (low < high) {

            int partitioningIndex = partition(array, low, high);

            quickSort(array, low, partitioningIndex - 1);

            quickSort(array, partitioningIndex + 1, high);

        }

    }

    public static void main(String[] args) {

        int[] array = { 12, 9, 4, 99, 120, 1, 3, 10, 23, 45, 75, 69, 31, 88, 101, 14, 29, 91, 2, 0, 77 };

        // print unsorted array

        System.out.println("--- Unsorted array before quicksort ---");

        for (int i : array) {

            System.out.print(i + " ");

        }

        System.out.println();

        // sort

        QuickSortCode.quickSort(array, 0, array.length - 1);

        // print sorted array

        System.out.println("--- Sorted array after quicksort ---");

        for (int i : array) {

            System.out.print(i + " ");

        }

        System.out.println();

        System.out.println("exchange count: " + QuickSortCode.exchangeCount);

    }
}