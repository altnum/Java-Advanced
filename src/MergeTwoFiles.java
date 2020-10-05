import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path path1 = Path.of("C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");

        List<String> newText = Files.readAllLines(path);
        List<String> newText2 = Files.readAllLines(path1);

        FileOutputStream writer = new FileOutputStream("output.txt");

        for (String str : newText) {
            writer.write(str.getBytes());
            writer.write("\n".getBytes());
        }

        writer.flush();

        for (String str :
                newText2) {
            writer.write(str.getBytes(), 0, str.length());
            writer.write("\n".getBytes(), 0, "\n".length());
        }

        writer.close();
    }
}
