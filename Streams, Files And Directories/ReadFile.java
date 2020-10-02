import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(path)) {
            int n = fileStream.read();

            while (n >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(n));
                n = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
