package programming2.unit2.NonGradedExercise;

/**
 * This class compares the execution time of recursive and iterative algorithms
 * for calculating the nth Fibonacci number.
 * 
 * @author Haruka Shitajikkoku
 */
public class RecursiveVsIterative_Fibonacci {

    /**
     * This method calculates the nth Fibonacci number recursively.
     *
     * @param n the index of the Fibonacci number to calculate
     * @return the nth Fibonacci number
     */
    public static int fibonacciRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    /**
     * This method calculates the nth Fibonacci number iteratively.
     *
     * @param n the index of the Fibonacci number to calculate
     * @return the nth Fibonacci number
     */
    public static int fibonacciIterative(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fib1 = 0, fib2 = 1, fib3 = 1;
        for (int i = 2; i <= n; i++) {
            fib3 = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib3;
        }
        return fib3;
    }

    /**
     * This is the main method which measures the execution time of recursive and
     * iterative algorithms for calculating
     * the nth Fibonacci number and prints the results to the console.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int n = 20; // change n to the desired value
        long startTime, endTime, elapsedTime;

        // Measure time for recursive function
        startTime = System.nanoTime();
        int resultRecursive = fibonacciRecursive(n);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Fibonacci using recursive algorithm: " + resultRecursive);
        System.out.println("Time taken by recursive algorithm: " + elapsedTime + " nanoseconds");

        // Measure time for iterative function
        startTime = System.nanoTime();
        int resultIterative = fibonacciIterative(n);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Fibonacci using iterative algorithm: " + resultIterative);
        System.out.println("Time taken by iterative algorithm: " + elapsedTime + " nanoseconds");
    }
}
