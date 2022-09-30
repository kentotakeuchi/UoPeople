package CS1102;

import javax.swing.JOptionPane;

public abstract class Question {
    abstract String ask();

    // class variables
    static int nQuestions = 0;
    static int nCorrect = 0;

    // instance variables
    String question;
    String correctAnswer;

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
