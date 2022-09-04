// Explain what is meant by the syntax and the semantics of a programming
// language.
/*
 * The syntax of a programming language is something that decides the vocabulary
 * of the programming language and how codes are built.
 * If the syntax is not correct, the programs are not even compiled or
 * interpreted.
 *
 * On the other hand, the semantics of a programming language is sort of the
 * meaning of the program.
 * Eck, D. J. (2019) explains the semantics more in detail.
 * "the semantics of a programming language is the set of rules that determine the meaning of a program written in that language"
 * (Eck, D. J., 2019).
 * Therefore, even if the program is syntactically correct and complied, it's a
 * semantics error if the result is not what you expected.
 */

// Give Java examples to illustrate the difference between a syntax error and a
// semantics error. Use different examples than those found in the textbook.
class Error {
    public Error() {
    }

    public void syntax() {
        System.out.printIn("Syntax Error.");
    }

    public float semantics(int num) {
        return num / 2;
    }

    public static void main(String[] args) {
        Error error = new Error();

        // call syntax function
        error.syntax();

        // call semantics function
        System.out.println(error.semantics(4));
        System.out.println(error.semantics(5));
        System.out.println(error.semantics(6));
    }
}

/*
 * Output
 * The method printIn(String) is undefined for the type PrintStream
 * 2.0
 * 2.0
 * 3.0
 */

/*
 * Explanation
 * As for the above syntax error, the syntax method is supposed to print out
 * "Syntax Error.", but gets an error because I wrote System.out.printIn instead
 * of System.out.println.
 * 
 * In case of the semantics error, the semantics method is supposed to divide
 * the parameter by 2, but the some return values are not what I expected
 * because the values are floored in Java.
 */

/*
 * References:
 * Eck, D. J. (2019). Introduction to programming using Java, version 8.1.
 * Hobart and William Smith College. http://math.hws.edu/javanotes
 */