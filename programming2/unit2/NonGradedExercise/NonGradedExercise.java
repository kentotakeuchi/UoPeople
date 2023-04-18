package programming2.unit2.NonGradedExercise;

/**
 * In many textbooks, the first examples of recursion are the mathematical
 * functions factorial and fibonacci. These functions are defined for
 * non-negative integers using the following recursive formulas:
 *
 * factorial(0) = 1
 * factorial(N) = N*factorial(N-1) for N > 0
 *
 * fibonacci(0) = 1
 * fibonacci(1) = 1
 * fibonacci(N) = fibonacci(N-1) + fibonacci(N-2) for N > 1
 *
 * Write recursive functions to compute factorial(N) and fibonacci(N) for a
 * given non-negative integer N, and write a main() routine to test your
 * functions.
 */
public class NonGradedExercise {

    /**
     * Compute the factorial of a non-negative integer.
     *
     * @param n non-negative integer
     * @return the result of the factorial of n
     */
    public static int factorial(int n) {
        if (n < 0)
            return 0;
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    /**
     * Compute the fibonacci of a non-negative integer.
     *
     * @param n non-negative integer
     * @return the result of the fibonacci number of n
     */
    public static int fibonacci(int n) {
        if (n < 2)
            return n;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Factorial(5): " + factorial(5));
        System.out.println("Factorial(10): " + factorial(10));
        System.out.println("Factorial(15): " + factorial(15));

        System.out.println("");

        System.out.println("Fibonacci(5)" + fibonacci(5));
        System.out.println("Fibonacci(10)" + fibonacci(10));
        System.out.println("Fibonacci(15)" + fibonacci(15));
    }

}
