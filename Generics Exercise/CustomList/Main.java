package CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        Box<String> box = new Box<>();

        while(!"END".equals(command)) {
            String[] info = command.split("\\s+");
            switch (info[0]) {
                case "Add":
                    box.Add(info[1]);
                    break;
                case "Remove":
                    box.Remove(Integer.parseInt(info[1]));
                    break;
                case "Contains":
                    System.out.println(box.Contains(info[1]));
                    break;
                case "Swap":
                    box.Swap(Integer.parseInt(info[1]), Integer.parseInt(info[2]));
                    break;
                case "Greater":
                    System.out.println(box.Compare(info[1]));
                    break;
                case "Max":
                    System.out.println(box.getMax());
                    break;
                case "Min":
                    System.out.println(box.getMin());
                    break;
                case "Print":
                    System.out.println(box.toString());
                    break;
            }
            command = reader.readLine();
        }
    }
}
