package CS1102;

import javax.swing.JOptionPane;

public class Quiz {
    public static int nQuestions = 0;
    public static int nCorrect = 0;

    public static String ask(String question) {
        while (true) {
            String answer = JOptionPane.showInputDialog(question);
            answer = answer.toUpperCase();
            // System.out.println(answer);
            if (answer.equals("A") || answer.equals("B") ||
                    answer.equals("C") ||
                    answer.equals("D") ||
                    answer.equals("E")) {
                return answer;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid answer. Please enter A, B, C, D, or E.");
            }
        }
    }

    public static void check(String question, String correctAnswer) {
        ++nQuestions;
        String answer = ask(question);
        if (answer.equals(correctAnswer)) {
            ++nCorrect;
            JOptionPane.showMessageDialog(null, "Correct!");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is " + correctAnswer + ".");
        }
    }

    public static void main(String[] args) {
        String question1 = "Which is my favorite fruit?\n";
        question1 += "A. Apple\n";
        question1 += "B. Passionfruit\n";
        question1 += "C. Kiwi\n";
        question1 += "D. Banana\n";
        question1 += "E. Dragonfruit\n";
        String correctAnswer1 = "D";
        check(question1, correctAnswer1);

        String question2 = "The latest iPhone is?\n";
        question2 += "A. 10\n";
        question2 += "B. 11\n";
        question2 += "C. 12\n";
        question2 += "D. 13\n";
        question2 += "E. 14\n";
        String correctAnswer2 = "E";
        check(question2, correctAnswer2);

        String question3 = "Which is my favorite sports?\n";
        question3 += "A. Soccer\n";
        question3 += "B. Baseball\n";
        question3 += "C. Basketball\n";
        question3 += "D. American Football\n";
        question3 += "E. Ice Hockey\n";
        String correctAnswer3 = "A";
        check(question3, correctAnswer3);

        JOptionPane.showMessageDialog(null, nCorrect + " correct out of " + nQuestions + " questions");
    }
}
