package programming1;

import javax.swing.JOptionPane;

public class test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        while (true) {
            String question = ("What is 2+2\n");
            question += ("A. 4\n");
            question += ("B. 7\n");
            question += ("C. 5\n");
            question += ("D. 10\n");
            question += ("E. all of the above\n");
            String answer = JOptionPane.showInputDialog(question);
            answer = answer.toUpperCase();
            {
                if (answer.equals("A")) {
                    JOptionPane.showMessageDialog(null, "Correct!");
                    break;
                } else if (answer.equals("B")) {
                    JOptionPane.showMessageDialog(null, "Incorrect :(, try again");
                } else if (answer.equals("C")) {
                    JOptionPane.showMessageDialog(null, "Incorrect :(, try again");
                } else if (answer.equals("D")) {
                    JOptionPane.showMessageDialog(null, "Incorrect :(, try again");
                } else if (answer.equals("E")) {
                    JOptionPane.showMessageDialog(null, "Incorrect :(, try again");
                } else {
                    JOptionPane.showMessageDialog(null, "Not a correct input");
                }
            }
        }
    }
}
