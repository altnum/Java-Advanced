import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        Stream<String> lines = reader.lines();
        List<String> strLines = lines.collect(Collectors.toList());
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        for (int i = 1; i < strLines.size(); i++) {
            if ((i + 1) % 3 == 0) {
                writer.write(strLines.get(i));
                writer.println();
            }
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}
