import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\files.zip");

        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file));

        Scanner scan= new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        ZipEntry e;

        for (int i = 0; i < n; i++) {
            String path = "D:\\" + scan.nextLine() + ".txt";
            FileInputStream filee = new FileInputStream(path);
            e = new ZipEntry(path);
            out.putNextEntry(e);

            byte[] data = filee.readAllBytes();
            out.write(data, 0, data.length);
        }
        out.closeEntry();
        out.close();

    }
}
