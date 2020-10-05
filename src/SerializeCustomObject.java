import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course c = new Course("Java", 12);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("course.ser"));
        out.writeObject(c);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("course.ser"));
        Course c1 = (Course)in.readObject();
    }
}
