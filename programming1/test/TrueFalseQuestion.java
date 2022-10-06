package programming1.test;

import javax.swing.JOptionPane;

public class TrueFalseQuestion extends Question {
	TrueFalseQuestion(String Question, String answer) {
		this.question = "TRUE or FALSE: " + question;
		answer = answer.toUpperCase();
		if (answer.equals("T") || answer.equals("Y") || answer.equals("YES") || answer.equals("TRUE")
				|| answer.equals("E")) {
			super.correctAnswer = "TRUE";
		} else if (answer.equals("F") || answer.equals("N") || answer.equals("NO") || answer.equals("FALSE")
				|| answer.equals("E")) {
			this.correctAnswer = "FALSE";
		}
	}

	String ask() {
		while (true) {
			String answer = JOptionPane.showInputDialog(question);
			answer = answer.toUpperCase();
			if (answer.equals("T") || answer.equals("Y") || answer.equals("YES") || answer.equals("TRUE")
					|| answer.equals("E")) {
				return "TRUE";
			} else if (answer.equals("F") || answer.equals("N") || answer.equals("NO") || answer.equals("FALSE")
					|| answer.equals("E")) {
				return "FALSE";
			} else {
				JOptionPane.showMessageDialog(null, "Invalid answer. Please enter FALSE orTRUE");
			}
		}
	}
}
