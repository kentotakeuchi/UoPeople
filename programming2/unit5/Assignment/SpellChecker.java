// package programming2.unit5.Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SpellChecker {

    public static void main(String[] args) {
        // Read the dictionary file and store the words in a HashSet
        Set<String> dictionary = new HashSet<>();
        try {
            Scanner filein = new Scanner(new File("words.txt"));
            while (filein.hasNext()) {
                String word = filein.next().toLowerCase();
                dictionary.add(word);
            }
            filein.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary file not found.");
            System.exit(1);
        }
        System.out.println("Dictionary size: " + dictionary.size());

        // Let the user select a file to check
        File inputFile = getInputFileNameFromUser();
        if (inputFile == null) {
            System.out.println("No file selected.");
            System.exit(1);
        }

        // Read the input file and check the spelling of each word
        Set<String> misspelledWords = new HashSet<>();
        try {
            Scanner in = new Scanner(inputFile);
            in.useDelimiter("[^a-zA-Z]+");
            while (in.hasNext()) {
                String word = in.next().toLowerCase();
                if (!dictionary.contains(word)) {
                    misspelledWords.add(word);
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
            System.exit(1);
        }

        // Print out the misspelled words and their possible corrections
        Set<String> alreadyOutput = new HashSet<>();
        for (String word : misspelledWords) {
            if (!alreadyOutput.contains(word)) {
                System.out.print(word + ": ");
                TreeSet<String> corrections = corrections(word, dictionary);
                if (corrections.isEmpty()) {
                    System.out.println("(no suggestions)");
                } else {
                    for (String correction : corrections) {
                        System.out.print(correction + ", ");
                    }
                    System.out.println();
                }
                alreadyOutput.add(word);
            }
        }
    }

    /**
     * This method takes a misspelled word and a HashSet of legal words, and returns
     * a TreeSet containing variations on the misspelled word that are contained in
     * the
     * dictionary.
     *
     * @param badWord    the misspelled word to be corrected
     * @param dictionary the HashSet of legal words
     * @return a TreeSet containing variations on the misspelled word that are
     *         contained in the dictionary
     */
    public static TreeSet<String> corrections(String badWord, HashSet<String> dictionary) {
        TreeSet<String> result = new TreeSet<>();
        // Delete any one of the letters from the misspelled word.
        for (int i = 0; i < badWord.length(); i++) {
            String variation = badWord.substring(0, i) + badWord.substring(i + 1);
            if (dictionary.contains(variation)) {
                result.add(variation);
            }
        }
        // Change any letter in the misspelled word to any other letter.
        for (int i = 0; i < badWord.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String variation = badWord.substring(0, i) + ch + badWord.substring(i + 1);
                if (dictionary.contains(variation)) {
                    result.add(variation);
                }
            }
        }
        // Insert any letter at any point in the misspelled word.
        for (int i = 0; i <= badWord.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String variation = badWord.substring(0, i) + ch + badWord.substring(i);
                if (dictionary.contains(variation)) {
                    result.add(variation);
                }
            }
        }
        // Swap any two neighboring characters in the misspelled word.
        for (int i = 0; i < badWord.length() - 1; i++) {
            String variation = badWord.substring(0, i) + badWord.charAt(i + 1) + badWord.charAt(i)
                    + badWord.substring(i + 2);
            if (dictionary.contains(variation)) {
                result.add(variation);
            }
        }
        // Insert a space at any point in the misspelled word (and check that both of
        // the words that are produced are in the dictionary)
        for (int i = 1; i < badWord.length(); i++) {
            String firstWord = badWord.substring(0, i);
            String secondWord = badWord.substring(i);
            if (dictionary.contains(firstWord) && dictionary.contains(secondWord)) {
                result.add(firstWord + " " + secondWord);
            }
        }
        return result;
    }

    /**
     * Lets the user select an input file using a standard file
     * selection dialog box. If the user cancels the dialog
     * without selecting a file, the return value is null.
     */
    public static File getInputFileNameFromUser() {
        JFileChooser fileDialog = new JFileChooser();
        fileDialog.setDialogTitle("Select File for Input");
        int option = fileDialog.showOpenDialog(null);
        if (option != JFileChooser.APPROVE_OPTION) {
            return null;
        } else {
            return fileDialog.getSelectedFile();
        }
    }

}
