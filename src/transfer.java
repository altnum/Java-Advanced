import java.io.*;
import java.util.*;

public class transfer {
    public static void main(String[] args) throws IOException {
        Map<String, String> forTransfer = new LinkedHashMap<>();

        String path = "D:C:\\Users\\Acer\\Desktop\\New folder\\text.txt";
        FileReader file = new FileReader(path);
        BufferedReader reader = new BufferedReader(file);
        FileOutputStream outputStream = new FileOutputStream("D:C:\\Users\\Acer\\Desktop\\New folder\\text1.txt");
        String line = reader.readLine();

        while (line != null) {
            String[] tokens = line.split("[,\\s+]");

            forTransfer.put(tokens[1], tokens[0]);

            line = reader.readLine();
        }

        file.close();
    }
}
