import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String table = ",.!?";

        FileInputStream fileRead = new FileInputStream(path);

        Scanner scan = new Scanner(fileRead);
        FileOutputStream fileWrite = new FileOutputStream("C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt");

        while (scan.hasNext()) {
            String line = scan.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (!table.contains(String.valueOf(line.charAt(i)))) {
                    fileWrite.write(line.charAt(i));
                }

            }
            fileWrite.write("\n".getBytes());
        }
    }
}
