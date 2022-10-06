package programming1.test;

public class Quiz {


    public static void main(String[] args) {

        MultipleChoiceQuestion question = new MultipleChoiceQuestion("When do moslems go for Juma prayers?",
                " Friday",
           "Tuesday",
                "Thursday",
                " Monday",
                "Sunday",
                 "a"
        );
        question.check();
        Question question2 = new MultipleChoiceQuestion("What is the second day of the week?",
                " Friday",
                "Tuesday",
                "Thursday",
                " Monday",
                "Sunday",
                "d"
        );
        question2.check();
        Question question3 = new MultipleChoiceQuestion("When do Catholics go for congrigational prayers?",
                " Friday",
                "Tuesday",
                "Thursday",
                " Monday",
                "Sunday",
                "e"
        );
        question3.check();
        Question question4 = new MultipleChoiceQuestion("Which of these is the African country?",
                " Rwanda",
                "Rasia",
                "Japan",
                " Turkey",
                "Ukrain",
                "a"
        );
        question4.check();
        Question question5 = new MultipleChoiceQuestion("Which of these is the capital city of Uganda?",
                " Lyantonde",
                "Ishaka",
                "Mbarara",
                "Kampala",
                "Gulu",
                "d"
        );
        question5.check();
        Question question6 = new TrueFalseQuestion("Should we marry from all tribes? ","y");
        question6.check();
        Question question7 = new TrueFalseQuestion("Should we help Refugees? ","y");
        question7.check();
        Question question8 = new TrueFalseQuestion("Should we promote womens' emancepation? ","y");
        question8.check();
        Question question9 = new TrueFalseQuestion("Drinking Should be abolished in Uganda? ","n");
        question9.check();
        Question question10 = new TrueFalseQuestion("Should we promote racism? ","n");
        question10.check();
        question.showResults();
    }
}
