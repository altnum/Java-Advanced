package GenericSwapMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Box<String> box = new Box<>();

        for (int i = 0; i < n; i++) {
            String text = reader.readLine();
            box.Add(text);
        }

        String[] info = reader.readLine().split("\\s+");
        box.Swap(Integer.parseInt(info[0]), Integer.parseInt(info[1]));

        System.out.println(box.toString());
    }
}
