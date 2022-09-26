package CS1102;

import javax.swing.JOptionPane;

public class MultipleChoiceQuestion {
    // class variables
    static int nQuestions = 0;
    static int nCorrect = 0;

    // instance variables
    String question;
    String correctAnswer;

    // constructor
    public MultipleChoiceQuestion(String query, String a, String b, String c, String d, String e, String answer) {
        question = query + "\n";
        question += "A. " + a + "\n";
        question += "B. " + b + "\n";
        question += "C. " + c + "\n";
        question += "D. " + d + "\n";
        question += "E. " + e;

        correctAnswer = answer.toUpperCase();
    }

    public String ask() {
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

    public void check() {
        ++nQuestions;
        String answer = ask();
        if (answer.equals(correctAnswer)) {
            ++nCorrect;
            JOptionPane.showMessageDialog(null, "Correct!");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is " + correctAnswer + ".");
        }
    }

    public void showResults() {
        JOptionPane.showMessageDialog(null, nCorrect + " correct out of " + nQuestions + " questions");
    }
}
