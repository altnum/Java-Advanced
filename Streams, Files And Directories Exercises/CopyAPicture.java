import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class CopyAPicture {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("D:\\1049736.jpg");
        FileInputStream in = new FileInputStream(String.valueOf(path));
        FileOutputStream out = new FileOutputStream("picture-copy.jpg");

        byte[] buffer = new byte[1024];
        int length = in.read(buffer);

        while (length > 0) {
            out.write(buffer, 0, length);
            length = in.read(buffer);
        }

        in.close();
        out.close();
    }
}
