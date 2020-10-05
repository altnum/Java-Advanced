
import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cub = new Cube("green", 15.3, 12.4, 3.0);

        ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream("myObjectCube.txt"));
        f.writeObject(cub);
        f.flush();
        f.close();
        ObjectInputStream fin = new ObjectInputStream(new FileInputStream("myObjectCube.txt"));
        Cube cu = (Cube)fin.readObject();
        System.out.println();
    }
}
