public class AlgorithmComparison {
    public static void main(String[] args) {
        int n = 1;

        // Double.compare(double d1, double d2)
        // d1 = d2 -> return 0
        // d1 < d2 -> return less than 0
        // d1 > d2 -> return greater than 0
        while (Double.compare(Math.pow(2, n), 1000 * Math.pow(n, 3)) < 0) {
            n++;
        }

        System.out.println("The first integer of n that '1000n^3 < 2^n' is: " + n);
    }
}