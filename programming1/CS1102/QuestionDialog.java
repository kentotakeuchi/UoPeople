package programming1.CS1102;

// import statements for JDialog and ActionListener
import java.awt.event.*;
import javax.swing.*;

// extend JDialog and promise to implement ActionListener
public class QuestionDialog extends JDialog implements ActionListener {
    // instance variable
    String answer;

    // an implementation of the actionPerformed method to support the ActionListener
    public void actionPerformed(ActionEvent e) {
        // set "answer" to the label of the button that generated the event "e"
        answer = e.getActionCommand();

        // return control by closing the dialog
        dispose();
    }
}
