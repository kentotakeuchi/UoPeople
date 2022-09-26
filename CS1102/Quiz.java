package CS1102;

public class Quiz {
    public static void main(String[] args) {
        MultipleChoiceQuestion question = new MultipleChoiceQuestion(
                "Which is my favorite fruit?",
                "Apple",
                "Passionfruit",
                "Kiwi",
                "Banana",
                "Dragonfruit",
                "d");

        question.check();

        MultipleChoiceQuestion question2 = new MultipleChoiceQuestion(
                "The latest iPhone is?",
                "10",
                "11",
                "12",
                "13",
                "14",
                "e");

        question2.check();

        MultipleChoiceQuestion question3 = new MultipleChoiceQuestion(
                "Which is my favorite sports?",
                "Soccer",
                "Baseball",
                "Basketball",
                "American Football",
                "Ice Hockey",
                "a");

        question3.check();

        MultipleChoiceQuestion question4 = new MultipleChoiceQuestion(
                "This week is Unit..?",
                "1",
                "2",
                "3",
                "4",
                "5",
                "d");

        question4.check();

        MultipleChoiceQuestion question5 = new MultipleChoiceQuestion(
                "What programming language does this course use?",
                "Java",
                "C++",
                "Python",
                "Solidity",
                "Assembly",
                "a");

        question5.check();
        question5.showResults();
    }
}
