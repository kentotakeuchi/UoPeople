package CS1102;

import javax.swing.JOptionPane;

public class TrueFalseQuestion extends Question {
    // constructor
    public TrueFalseQuestion(String question, String answer) {
        this.question = "TRUE or FALSE: " + question;
        this.correctAnswer = answer;
    }

    @Override
    public String ask() {
        while (true) {
            String answer = JOptionPane.showInputDialog(question);
            answer = answer.toUpperCase();

            if (answer.equals("T") || answer.equals("TRUE") || answer.equals("Y") || answer.equals("YES"))
                answer = "TRUE";
            else if (answer.equals("F") || answer.equals("FALSE") || answer.equals("N") || answer.equals("NO"))
                answer = "FALSE";
            // System.out.println(answer);

            if (answer.equals("TRUE") || answer.equals("FALSE")) {
                return answer;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid answer. Please enter TRUE or FALSE.");
            }
        }
    }
}
