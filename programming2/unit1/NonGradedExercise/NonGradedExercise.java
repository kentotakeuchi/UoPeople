package programming2.unit1.NonGradedExercise;

/*
 * The program to solve equations specified by the user
 */
public class NonGradedExercise {
    /**
     * Returns the larger of the two roots of the quadratic equation
     * A*x*x + B*x + C = 0, provided it has any roots. If A == 0 or
     * if the discriminant, B*B - 4*A*C, is negative, then an exception
     * of type IllegalArgumentException is thrown.
     */
    static public double root(double A, double B, double C)
            throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        } else {
            double disc = B * B - 4 * A * C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-B + Math.sqrt(disc)) / (2 * A);
        }
    }

    public static void main(String[] args) {
        boolean tryAgain = true;

        while (tryAgain) {
            try {
                System.out.print("Enter A: ");
                double a = TextIO.getlnDouble();
                System.out.print("Enter B: ");
                double b = TextIO.getlnDouble();
                System.out.print("Enter C: ");
                double c = TextIO.getlnDouble();
                double root = root(a, b, c);
                System.out.println("Root: " + root);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.print("Continue? (Y/N): ");
                String answer = TextIO.getlnString();
                tryAgain = answer.equalsIgnoreCase("Y");
            }
        }

        System.out.println("Game over");
    }
}
