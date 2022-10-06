package programming1.test;

import javax.swing.JOptionPane;

public abstract class Question {
	static int nQuestions = 0;
	static int nCorrect = 0;
	String question;
	String correctAnswer;

	void check() {
		nQuestions++;
		nCorrect++;
		String answer = ask();
		if (answer.equals("A")) {
			JOptionPane.showMessageDialog(null, "correct");
		} else if (answer.equals("B")) {
			JOptionPane.showMessageDialog(null, "incorrect, The correct answer is ." + correctAnswer);

		} else if (answer.equals("C")) {
			JOptionPane.showMessageDialog(null, "incorrect, The correct answer is ." + correctAnswer);

		} else if (answer.equals("D")) {
			JOptionPane.showMessageDialog(null, "correct, The  answer is ." + correctAnswer);

		} else if (answer.equals("E")) {
			JOptionPane.showMessageDialog(null, "correct, answer is  . " + correctAnswer);

		} else {
			JOptionPane.showMessageDialog(null, "correct,The correct answer is  . " + correctAnswer);
		}
	}

	static void showResults() {
		JOptionPane.showMessageDialog(null, "correct out of questions. " + nCorrect + "/" + nQuestions);
	}

	abstract String ask();
}
