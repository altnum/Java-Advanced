import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

public class ListFiles {
    public static void main(String[] args) {
        Path path = Path.of("C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File folder = new File(String.valueOf(path));

        File[] files = Objects.requireNonNull(folder.listFiles());

        for (File f: files) {
            if (f.getName().contains("."))
                System.out.printf("%s: [%d]%n", f.getName(), f.length());
        }
    }
}
