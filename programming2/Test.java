package programming2;

import java.util.Random;

/**
 * This program generates sentences by branching with probability.
 * It is not infinite recursive, but the loop is infinite,
 * so if you are running the program from the command prompt,
 * hold down the "Ctrl" key and press the "C" key to stop execution.
 */

public class Test {

    static Random rand = new Random();

    static final String[] conjunctions = { "and", "or", "but", "because" };
    static final String[] properNouns = { "Fred", "Jane", "Richard Nixon", "Miss America" };
    static final String[] commonNouns = { "man", "woman", "fish", "elephant", "unicorn" };
    static final String[] determiners = { "a", "the", "every", "some" };
    static final String[] adjectives = { "big", "tiny", "pretty", "bald" };
    static final String[] intransitiveVerbs = { "runs", "jumps", "talks", "sleeps" };
    static final String[] transitiveVerbs = { "loves", "hates", "sees", "knows", "looks for", "finds" };

    /**
     * Main method to generate random sentences and print them to the console
     */

    public static void main(String[] args) {
        while (true) {
            randomSentence();
            System.out.println(".\n\n");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * Generates a random sentence using randomSimpleSentence() and has a 30% chance
     * to add conjunction and sentence
     */
    static void randomSentence() {
        randomSimpleSentence();
        if (rand.nextInt(10) < 3) { // 30% chance to add conjunction and sentence
            System.out.print(conjunctions[rand.nextInt(conjunctions.length)] + " ");
            randomSentence();
        }
    }

    /**
     * Generates a random simple sentence by calling randomNounPhrase() and
     * randomVerbPhrase()
     */
    static void randomSimpleSentence() {
        randomNounPhrase();
        randomVerbPhrase();
    }

    /**
     * Generates a random noun phrase with a 50% chance to use proper noun or
     * determiner and common noun.
     * Also has a 50% chance to add an adjective and a 30% chance to add a "who"
     * clause.
     */
    static void randomNounPhrase() {
        if (rand.nextBoolean()) { // 50% chance to use proper noun
            System.out.print(properNouns[rand.nextInt(properNouns.length)] + " ");
        } else { // 50% chance to use determiner and common noun
            System.out.print(determiners[rand.nextInt(determiners.length)] + " ");
            if (rand.nextBoolean()) { // 50% chance to add adjective
                System.out.print(adjectives[rand.nextInt(adjectives.length)] + " ");
            }
            System.out.print(commonNouns[rand.nextInt(commonNouns.length)] + " ");
            if (rand.nextInt(10) < 3) { // 30% chance to add "who" clause
                System.out.print("who ");
                randomVerbPhrase();
            }
        }
    }

    /**
     * Generates a random verb phrase with a 30% chance to use intransitive verb,
     * 30% chance to use transitive verb, 20% chance to use "is" clause, and 20%
     * chance to use "believes that" clause
     */
    static void randomVerbPhrase() {
        int r = rand.nextInt(10);
        if (r < 3) { // 30% chance to use intransitive verb
            System.out.print(intransitiveVerbs[rand.nextInt(intransitiveVerbs.length)] + " ");
        } else if (r < 6) { // 30% chance to use transitive verb
            System.out.print(transitiveVerbs[rand.nextInt(transitiveVerbs.length)] + " ");
            randomNounPhrase();
        } else if (r < 8) { // 20% chance to use "is" clause
            System.out.print("is " + adjectives[rand.nextInt(adjectives.length)] + " ");
        } else { // 20% chance to use "believes that" clause
            System.out.print("believes that ");
            randomSimpleSentence();
        }
    }

}
