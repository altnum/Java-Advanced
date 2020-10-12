package CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        List<Cat> catList = new LinkedList<>();

        while (!"End".equals(input)) {
            String[] info = input.split("\\s+");
            if ("Siamese".equals(info[0])) {
                Siamese siamese = new Siamese(info[1], info[0], Double.parseDouble(info[2]));
                catList.add(siamese);
            } else if ("Cymric".equals(info[0])) {
                Cymric cymric = new Cymric(info[1], info[0], Double.parseDouble(info[2]));
                catList.add(cymric);
            } else if ("StreetExtraordinaire".equals(info[0])) {
                StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(info[1], info[0], Double.parseDouble(info[2]));
                catList.add(streetExtraordinaire);
            }
            input = reader.readLine();
        }

        String name = reader.readLine();

        for (Cat c: catList) {
            if (c.getName().equals(name)) {
                System.out.println(c.toString());
            }
        }
    }
}
