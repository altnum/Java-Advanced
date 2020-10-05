import java.io.*;
import java.nio.file.Path;

public class SumLines {
    public static void main(String[] args) throws FileNotFoundException {
        Path path = Path.of("C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt");
        try (BufferedReader file = new BufferedReader(new FileReader(String.valueOf(path)))) {
            String line = file.readLine();

            while (line != null) {
                int sum = 0;

                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }

                System.out.println(sum);

                line = file.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
