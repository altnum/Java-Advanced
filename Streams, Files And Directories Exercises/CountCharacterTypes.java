import java.io.*;
import java.nio.file.Path;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        int countVowels = 0;
        int consonants = 0;
        int countPunctuations = 0;
        String vowels = "aeiou";
        String punctuations = "!,.?";

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();

        while (line != null) {
            String[] words = line.split("\\s+");

            for (String word: words) {
                for (char symbol: word.toCharArray()) {
                    String charAsString = String.valueOf(symbol);
                    if (vowels.contains(charAsString)) {
                        countVowels++;
                    } else if (punctuations.contains(charAsString)) {
                        countPunctuations++;
                    } else {
                        consonants++;
                    }
                }
            }
            line = reader.readLine();
        }
        reader.close();

        PrintWriter printer = new PrintWriter("output1.txt");
        printer.println("Vowels: " + countVowels);
        printer.println("Consonants: " + consonants);
        printer.println("Punctuation: " + countPunctuations);

        printer.close();
    }
}
