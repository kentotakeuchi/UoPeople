package programming2.unit2.SimpleRandomSentences;

public class Main {
    public static void main(String[] args) {
        SimpleRandomSentences generator1 = new SimpleRandomSentences(10);
        generator1.generate();

        SimpleRandomSentences generator2 = new SimpleRandomSentences(50);
        generator2.generate();

        SimpleRandomSentences generator3 = new SimpleRandomSentences(100);
        generator3.generate();
    }
}
