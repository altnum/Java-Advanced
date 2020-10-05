import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        Path path2 = Path.of("C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        Map<String, Integer> words = new LinkedHashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));
        String line = reader.readLine();

        while (line != null) {
            String[] tokens = line.split("\\s+");

            for (String t: tokens) {
                words.put(t, 0);
            }

            line = reader.readLine();
        }

        reader = new BufferedReader(new FileReader(String.valueOf(path2)));

        line = reader.readLine();

        while (line != null) {
            String[] tokens = line.split("\\s+");

            for (String t: tokens) {
                if (words.containsKey(t))
                    words.put(t, words.get(t) + 1);
            }

            line = reader.readLine();
        }

        words.forEach((k, v) -> System.out.printf("%s - %d%n", k, v));
    }
}
