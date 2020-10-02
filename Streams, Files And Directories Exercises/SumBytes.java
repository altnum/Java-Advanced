import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        Path pathFile = Path.of(path);

        long sum = 0;

        byte[] values = Files.readAllBytes(pathFile);

        for (byte value: values) {
            if (value == 10 || value == 13) {
                continue;
            }
            sum += value;
        }

        System.out.println(sum);
    }
}
