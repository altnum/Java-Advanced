package CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new LinkedList<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split("\\s+");

            if (info.length == 4) {
                Engine engine = new Engine(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), info[3]);
                engines.add(engine);
            } else if (info.length == 3) {
                Engine engine;
                try {
                    engine = new Engine(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]));
                } catch (Exception e) {
                    engine = new Engine(info[0], Integer.parseInt(info[1]), info[2]);
                }

                engines.add(engine);
            } else if (info.length == 2) {
                Engine engine = new Engine(info[0], Integer.parseInt(info[1]));
                engines.add(engine);
            }
        }

        int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < m; i++) {
            String[] info = reader.readLine().split("\\s+");
            Engine engineToAdd = null;

            for (Engine e :engines) {
                if (e.getModel().equals(info[1]))
                    engineToAdd = e;
            }

            if (info.length == 4) {
                Car car = new Car(info[0], engineToAdd, Integer.parseInt(info[2]), info[3]);
                cars.add(car);
            } else if (info.length == 3) {
                Car car;
                try {
                    car = new Car(info[0], engineToAdd, Integer.parseInt(info[2]));
                } catch (Exception e) {
                    car = new Car(info[0], engineToAdd, info[2]);
                }
                cars.add(car);
            } else if (info.length == 2) {
                Car car = new Car(info[0], engineToAdd);
                cars.add(car);
            }
        }

        cars.forEach(System.out::println);
    }
}
