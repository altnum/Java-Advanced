import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Double> d = new ArrayList<>();
        d.add(1d);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("list.ser"));
        out.writeObject(d);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("list.ser"));
        List<Double> list = (List<Double>)in.readObject();
        System.out.println();
    }
}
