import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        Path pathFile = Path.of(path);

        List<String> lines = Files.readAllLines(pathFile);
        PrintWriter writer = new PrintWriter("output.txt");

        lines.forEach(line -> writer.println(line.toUpperCase()));
        writer.close();

    }
}
