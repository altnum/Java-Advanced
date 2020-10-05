import java.io.*;
import java.nio.file.Path;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputLineNumbers.txt");
        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));
        String line = reader.readLine();
        int count = 1;
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        while (line != null) {
            StringBuilder lineSb = new StringBuilder(String.valueOf(count));
            lineSb.append(". ");
            lineSb.append(line);
            writer.write(String.valueOf(lineSb));
            writer.write("\n");
            line = reader.readLine();
            count++;
        }

        reader.close();
        writer.close();



    }
}
