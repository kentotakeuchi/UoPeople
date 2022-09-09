package programming1.unit2;

import java.util.Scanner;

public class Discussion {
    public static void main(String[] args) {
        // 1) give an example of a while loop, then provide the equivalent do-while loop
        // and for loop.

        // 1-1) while loop
        int x = 3;

        while (x > 0) {
            System.out.printf("%d is a positive integer.\n", x);
            --x;
        }

        System.out.println();

        // 1-2) do-while loop
        int y = 3;

        do {
            System.out.printf("%d is a positive integer.\n", y);
            --y;
        } while (y > 0);

        System.out.println();

        // 1-3) for loop
        for (int i = 3; i > 0; --i) {
            System.out.printf("%d is a positive integer.\n", i);
        }

        System.out.println();

        // 2) give a different example of a do-while loop, along with the equivalent
        // while loop and for loop
        Scanner sc = new Scanner(System.in);
        String input = "";

        // 2-1) do-while loop
        do {
            System.out.println("How are you doing?: ");
            input = sc.next();
        } while (!input.equals("exit"));

        input = "";

        // 2-2) while loop
        while (!input.equals("exit")) {
            System.out.println("How are you?: ");
            input = sc.next();
        }
        ;

        input = "";

        // 2-3) for loop
        for (int i = 0; i < 10; --i) {
            System.out.println("What's up?: ");
            input = sc.next();
            if (input.equals("exit"))
                break;
        }
        ;

        sc.close();
        System.out.println();

        // 3) give an example of a for loop, along with the equivalent while loop and
        String[] fruits = { "apple", "orange", "pineapple" };

        // 3-1) for loop
        for (int i = 0; i < fruits.length; ++i) {
            System.out.printf("%s is my favorite fruit.\n", fruits[i]);
        }

        System.out.println();

        // 3- 2) while loop
        int i = 0;
        while (i < fruits.length) {
            System.out.printf("%s is my favorite fruit.\n", fruits[i++]);
        }

        System.out.println();

        // 3-3) do-while loop
        int j = -1;
        do {
            System.out.printf("%s is my favorite fruit.\n", fruits[++j]);
        } while (j < fruits.length - 1);
    };
};

/*
 Output

 3 is a positive integer.
 2 is a positive integer.
 1 is a positive integer.

 3 is a positive integer.
 2 is a positive integer.
 1 is a positive integer.

 3 is a positive integer.
 2 is a positive integer.
 1 is a positive integer.

How are you doing?:
good
How are you doing?:
exit
How are you?:
ok
How are you?:
exit
What's up?:
fine
What's up?:
exit

apple is my favorite fruit.
orange is my favorite fruit.
pineapple is my favorite fruit.

apple is my favorite fruit.
orange is my favorite fruit.
pineapple is my favorite fruit.

apple is my favorite fruit.
orange is my favorite fruit.
pineapple is my favorite fruit.
 */

/*
  A while loop is shined when we don’t know how many times you need to loop over.
  In my example1, a variable “x” is initialized as 3, so we know we need to iterate 3 times.
  However, even if we don’t know the value of “x”, if we use the while loop,
  On the other hand, if we want to do something in each loop before checking some conditions, the while loop is not convenient as my example2.
  In addition, if we want to iterate an array, the code looped over by the while loop is not as clean as a for loop.
  As you can see in my example3, we need to declare a variable “i” outside of the while loop, which is error-prone.

  A do-while loop is convenient when we want to execute the statements inside the loop at least once in addition to the advantage of the while loop.
  I think that one of the typical use cases is a user prompt as in my example2.
  The program needs to ask a user to type something at least once. However, when we want to loop over an array as in my example3, the condition to loop over the array properly could be a bit tricky.

  A for loop is better to use when we know how many times we need to iterate.
  As you can see in my example3, if we want to iterate “fruits” which is an array, the for loop is quite handy. On the flip side, if we don’t know how many times it is necessary to iterate, the for loop is not as straightforward as the while loop.
 */
