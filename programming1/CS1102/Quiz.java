package programming1.CS1102;

public class Quiz {
        public static void main(String[] args) {
                // MultipleChoiceQuestion
                Question question = new MultipleChoiceQuestion(
                                "Which is my favorite fruit?",
                                "Apple",
                                "Passionfruit",
                                "Kiwi",
                                "Banana",
                                "Dragonfruit",
                                "d");

                question.check();

                Question question2 = new MultipleChoiceQuestion(
                                "The latest iPhone is?",
                                "10",
                                "11",
                                "12",
                                "13",
                                "14",
                                "e");

                question2.check();

                Question question3 = new MultipleChoiceQuestion(
                                "Which is my favorite sports?",
                                "Soccer",
                                "Baseball",
                                "Basketball",
                                "American Football",
                                "Ice Hockey",
                                "a");

                question3.check();

                Question question4 = new MultipleChoiceQuestion(
                                "This week is Unit..?",
                                "1",
                                "2",
                                "3",
                                "4",
                                "5",
                                "d");

                question4.check();

                Question question5 = new MultipleChoiceQuestion(
                                "What programming language does this course use?",
                                "Java",
                                "C++",
                                "Python",
                                "Solidity",
                                "Assembly",
                                "a");

                question5.check();

                // TrueFalseQuestion
                Question question6 = new TrueFalseQuestion("Is this year 2022?", "TRUE");
                question6.check();

                Question question7 = new TrueFalseQuestion("Was UoPeople launched in 2009?", "TRUE");
                question7.check();

                Question question8 = new TrueFalseQuestion("Is the founder of UoPeople Shai Reshef?", "TRUE");
                question8.check();

                Question question9 = new TrueFalseQuestion("Was UoPeople accredited?", "TRUE");
                question9.check();

                Question question10 = new TrueFalseQuestion("Is the office of UoPeople in Arizona?", "NO");
                question10.check();

                question10.showResults();
        }
}
