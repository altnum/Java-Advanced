import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        Scanner scan = new Scanner(new FileInputStream(path));

        while (scan.hasNext()) {
            if (scan.hasNextInt())
                System.out.println(scan.nextInt());
            scan.next();
        }
    }
}
