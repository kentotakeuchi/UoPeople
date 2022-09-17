package programming1.unit3;

/*
What are parameters for?
Parameters are part of the interface of a method and local variables inside the method.
Parameters are defined before being executed the method.
Since a method performs the same task, parameters are the only way to change the return value.
As a method is independent of the outside world and always executes the same task, it is not useful without parameters.
Passing parameters to a method gives flexibility.
*/

/*
What is the difference between formal parameters and actual parameters?
Formal parameters are a sort of local variables in a method that is defined before executing the method.
On the other hand, actual parameters are parameters that are passed to a method when the method is called.
*/

// The example of formal and actual parameters.
public class Discussion {
    // The parameters n1 and n2 in the addTwoIntegers method are formal parameters.
    public static int addTwoIntegers(int n1, int n2) {
        return n1 + n2;
    }

    public static void main(String[] args) {
        // Integer 1 and 9 passed to the addTwoIntegers method are actual parameters in
        // this case.
        int sum1 = addTwoIntegers(1, 9);
        // Integer 10 and 10 passed to the addTwoIntegers method are actual parameters
        // in this case.
        int sum2 = addTwoIntegers(10, 10);
        // Integer 100 and 1 passed to the addTwoIntegers method are actual parameters
        // in this case.
        int sum3 = addTwoIntegers(100, 1);
        System.out.printf("sum1: %d\n", sum1);
        System.out.printf("sum2: %d\n", sum2);
        System.out.printf("sum3: %d\n", sum3);
    }

}

/*
 * References
 * Eck, D. J. (2019). Introduction to programming using Java, version 8.1.
 * http://math.hws.edu/javanotes
 */
