import java.io.File;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class NestedFolders {
    public static void main(String[] args) {
        Path path = Path.of("C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File folder = new File(String.valueOf(path));

        Deque<File> deque = new ArrayDeque<>();

        deque.add(folder);
        int count = 0;

        while (!deque.isEmpty()) {
            File f = deque.poll();
            count++;
            System.out.println(f.getName());

            File[] files = f.listFiles();

            for (File innerFile: files) {
                if (innerFile.isDirectory())
                    deque.offer(innerFile);
            }
        }

        System.out.println(count + " folders");
    }
}
