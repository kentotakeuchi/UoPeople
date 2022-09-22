package programming1;

import javax.swing.JOptionPane;

public class test {
    static int nQuestions = 0;
    static int nCorrect = 0;

    static String ask(String question) {
        while (true) {
            String answer = JOptionPane.showInputDialog(question);
            answer = answer.toUpperCase();
            boolean valid = (answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("D")
                    || answer.equals("E"));
            if (valid)
                return answer;
            JOptionPane.showMessageDialog(null, "Invalid answer. Please enter A, B, C, D, or E.");
        }
    }

    static void check(String question, String correctAnswer) {
        nQuestions++;
        String answer = ask(question);
        {
            if (answer.equals(correctAnswer)) {
                JOptionPane.showMessageDialog(null, "That is correct");
                nCorrect++;
            } else {
                JOptionPane.showMessageDialog(null, "That is incorrect. The correct answer is:\n" + correctAnswer);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String question = "What is 2*2?\n";

        question += "A. 4\n";
        question += "B. 7\n";
        question += "C. 5\n";
        question += "D. 32\n";
        question += "E. All of the above\n";
        check(question, "A");

        question = "What is the capital of Texas?\n";
        question += "A. Houston\n";
        question += "B. Dallas\n";
        question += "C. El Paso\n";
        question += "D. Austin\n";
        question += "E. San Antonio\n";
        check(question, "D");

        question = "How much wood could a woodchuck chuck if a woodchuck could chuck wood?\n";
        question += "A. ¯\\_(ツ)_/¯\n";
        question += "B. All of it\n";
        question += "C. 42\n";
        question += "D. 17\n";
        question += "E. None\n";
        check(question, "C");
        JOptionPane.showMessageDialog(null, "You got " + nCorrect + " right out of " + nQuestions + " questions");
    }
}
