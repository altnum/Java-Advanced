package Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String[] p = reader.readLine().split("\\s+");
            Threeuple<String, String, String> person = new Threeuple<String, String,String>(p[0] + " " + p[1], p[2], p[3]);

            String[] b = reader.readLine().split("\\s+");
            boolean res;
            if ("drunk".equals(b[2]))
                res = true;
            else
                res = false;

            Threeuple<String, Integer, Boolean> drunk = new Threeuple<String, Integer, Boolean>(b[0], Integer.parseInt(b[1]), res);
            String[] ids = reader.readLine().split("\\s+");
            Threeuple<String, Double, String> bank = new Threeuple<String, Double, String>(ids[0], Double.parseDouble(ids[1]), ids[2]);

            System.out.println(person.toString());
            System.out.println(drunk.toString());
            System.out.println(bank.toString());
        }
}
