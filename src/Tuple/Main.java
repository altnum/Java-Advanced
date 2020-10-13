package Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Tuple<String, String> person = new Tuple<String, String>();
        Tuple<String, Integer> beer = new Tuple<String, Integer>();
        Tuple<Integer, Double> id = new Tuple<Integer, Double>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] p = reader.readLine().split("\\s+");
        person.setValues1(p[0] + " " + p[1]);
        person.setValues2(p[2]);
        String[] b = reader.readLine().split("\\s+");
        beer.setValues1(b[0]);
        beer.setValues2(Integer.parseInt(b[1]));
        String[] ids = reader.readLine().split("\\s+");
        id.setValues1(Integer.parseInt(ids[0]));
        id.setValues2(Double.parseDouble(ids[1]));

        System.out.println(person.toString());
        System.out.println(beer.toString());
        System.out.println(id.toString());
    }
}
