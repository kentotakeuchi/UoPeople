package programming2.unit1.MathQuiz;

public class MathQuiz {

    public static void main(String[] args) {
        // System.out.print("What's your name?");
        // String name = TextIO.getln();
        // System.out.println("Pleased to meet you, " + name);

        AdditionProblem problem = new AdditionProblem();
        System.out.println(problem.getProblem());
        System.out.println(problem.getAnswer());
    }
}
