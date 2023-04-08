package programming2.unit1.BenchmarkingSortingAlgorithms;

/*
 * You should run your program using array sizes of 1,000, 10,000, and 100,000. Record the sort times. Add a comment to the top of the program that reports the times.
 * ---
 * Array size: 1000
 * selectionSort(): 6 ms
 * Arrays.sort(): 2 ms
 *
 * Array size: 10000
 * selectionSort(): 79 ms
 * Arrays.sort(): 5 ms
 *
 * Array size: 100000
 * selectionSort(): 2897 ms
 * Arrays.sort(): 19 ms
 * ---
 * The built-in method "Arrays.sort()" is faster than the method "selectionSort()" from the textbook.
 */
public class Main {
    public static void main(String[] args) {
        BenchmarkingSortingAlgorithms benchMark1 = new BenchmarkingSortingAlgorithms(1000);
        benchMark1.run();
        benchMark1.printResult();

        BenchmarkingSortingAlgorithms benchMark2 = new BenchmarkingSortingAlgorithms(10000);
        benchMark2.run();
        benchMark2.printResult();

        BenchmarkingSortingAlgorithms benchMark3 = new BenchmarkingSortingAlgorithms(100000);
        benchMark3.run();
        benchMark3.printResult();
    }
}
