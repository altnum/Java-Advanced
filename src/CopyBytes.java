import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream fileRead = new FileInputStream(path);
        FileOutputStream fileWrite = new FileOutputStream("C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt");
        int oneByte = fileRead.read();

        while (oneByte >= 0) {
            String str = String.valueOf(oneByte);
            if (oneByte == 32) {
                fileWrite.write(" ".getBytes());
            } else if (oneByte == 10) {
                fileWrite.write("\n".getBytes());
            } else {
                for (int i = 0; i < str.length(); i++) {
                    fileWrite.write(str.charAt(i));
                }
            }
            oneByte = fileRead.read();
        }
    }
}
