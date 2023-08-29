import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Word Counting Program");
        System.out.println("---------------------");

        String text = getInputText(scanner);
        String[] words = text.split("[\\s.,;!?()\"']+");

        int totalWords = words.length;
        System.out.println("Total words: " + totalWords);

        displayUniqueWords(words);
        displayWordFrequency(words);

        scanner.close();
    }

    private static String getInputText(Scanner scanner) {
        System.out.println("Enter 'text' to provide input text, or 'file' to provide a file path:");
        String inputType = scanner.nextLine().toLowerCase();

        if (inputType.equals("text")) {
            System.out.println("Enter the text:");
            return scanner.nextLine();
        } else if (inputType.equals("file")) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            try {
                return new Scanner(new File(filePath)).useDelimiter("\\Z").next();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                System.exit(1);
            }
        } else {
            System.out.println("Invalid input.");
            System.exit(1);
        }
        return null;
    }

    private static void displayUniqueWords(String[] words) {
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Unique words: " + uniqueWords.size());
    }

    private static void displayWordFrequency(String[] words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
