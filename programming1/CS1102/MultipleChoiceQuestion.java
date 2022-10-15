package programming1.CS1102;

import java.awt.*;
import javax.swing.*;

public class MultipleChoiceQuestion extends Question {

    // constructor
    public MultipleChoiceQuestion(String query, String a, String b, String c, String d, String e, String answer) {
        super(query);

        // add choice
        addChoice("A", a);
        addChoice("B", b);
        addChoice("C", c);
        addChoice("D", d);
        addChoice("E", e);

        // add choices for the other formal parameters: "b", "c", "d", and "e".
        // perform the rest of the initialization of the dialog box by calling
        // "initQuestionDialog".
        initQuestionDialog();

        correctAnswer = answer.toUpperCase();
    }

    public void addChoice(String name, String label) {
        // create a panel to arrange the button and the label
        JPanel choice = new JPanel(new BorderLayout());

        // create a button with the given name
        JButton button = new JButton(name);

        // wire this button into the actionPerformed method of the "question" object, so
        // it will record the answer if the button is clicked
        button.addActionListener(question);

        // add this button to the "choice" panel, aligned to the left, or WEST, border
        // of the panel
        choice.add(button, BorderLayout.WEST);

        // add the answer label to the center section of the panel, with some extra
        // spaces on the end to keep the label from appearing too close to the edge of
        // the dialog box
        choice.add(new JLabel(label + " ", JLabel.LEFT), BorderLayout.CENTER);

        // add the panel holding the button and answer label to the dialog box
        question.add(choice);
    }
}
