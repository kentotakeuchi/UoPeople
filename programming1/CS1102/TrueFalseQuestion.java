package programming1.CS1102;

import javax.swing.*;

public class TrueFalseQuestion extends Question {
    // constructor
    public TrueFalseQuestion(String question, String answer) {
        // create a "Question" constructor that takes a String "question" parameter
        super(question);

        // create a new JPanel to organize the true/false buttons
        JPanel buttons = new JPanel();

        // add true/false buttons to the dialog box
        addButton(buttons, "TRUE");
        addButton(buttons, "FALSE");

        // add the "buttons" panel to the dialog box itself
        this.question.add(buttons);

        // make "question" modal, set its size, and set its position
        initQuestionDialog();

        // the initialization of the "answer" String
        this.correctAnswer = answer;
    }

    void addButton(JPanel buttons, String label) {
        // create a new button with the provided label
        JButton button = new JButton(label);

        // wire the question object up to the new button by adding it as a listener
        button.addActionListener(question);

        // add the button to the "buttons" panel
        buttons.add(button);
    }
}
