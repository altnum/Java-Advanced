import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        List<String> lines= new ArrayList<>();
        lines = Files.readAllLines(path);
        Collections.sort(lines);

        FileOutputStream writer = new FileOutputStream("C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt");

        for (String line : lines) {
            if (!"".equals(line)) {
                writer.write(line.getBytes());
                writer.write("\n".getBytes());
            }
        }

        writer.close();
    }
}
