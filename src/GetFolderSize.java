import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\Acer\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        long size = 0;

        for (File file: folder.listFiles()) {
            size += file.length();
        }

        System.out.println("Folder size: " + size);
    }
}
