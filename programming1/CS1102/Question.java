package programming1.CS1102;

import java.awt.*;
import javax.swing.*;

public abstract class Question {
    // class variables
    static int nQuestions = 0;
    static int nCorrect = 0;

    // instance variables
    QuestionDialog question;
    String correctAnswer;

    Question(String question) {
        this.question = new QuestionDialog();

        // the dialog box will have a single question with buttons below
        // give it a grid layout with one column and any number of rows
        this.question.setLayout(new GridLayout(0, 1));

        // add the "question" String to the window as a "JLabel"
        // center it using "JLabel.CENTER"
        // add some spaces to each end of the String to keep it from getting too close
        // to the edges of the dialog window
        this.question.add(new JLabel("    " + question + "    "), JLabel.CENTER);
    }

    public void initQuestionDialog() {
        // make the dialog box "modal"
        question.setModal(true);

        // resize the dialog box based on its contents
        question.pack();

        // center the dialog box on the screen
        question.setLocationRelativeTo(null);
    }

    public String ask() {
        // a statement to make the "question" dialog box visible
        question.setVisible(true);

        // once the "question" dialog box returns from SetVisible, it has set its answer
        // have the "ask" method return the answer
        return question.answer;
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
