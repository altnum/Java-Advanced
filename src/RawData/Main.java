package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Double, Integer> tires = new LinkedHashMap<>();
        List<Car> cars = new LinkedList<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split("\\s+");

            for (int j = 5; j < info.length; j++) {
                tires.put(Double.parseDouble(info[j]), Integer.parseInt(info[j + 1]));
                j++;
            }

            Car car = new Car(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]),
                    Integer.parseInt(info[3]), info[4], tires);
            cars.add(car);
        }

        String command = reader.readLine();

        if ("fragile".equals(command)) {
            cars.forEach(e -> {
                AtomicBoolean smallerThanOne = new AtomicBoolean(false);
                e.getTires().keySet().forEach(k ->  {
                    if (k < 1)
                        smallerThanOne.set(true);
                });
                if (e.getCargo().getCargoType().equals("fragile") && smallerThanOne.get()) {
                    System.out.println(e.getModel());
                }
            });
        } else if ("flamable".equals(command)) {
            cars.forEach(e -> {
                if (e.getCargo().getCargoType().equals("flamable") && e.getEngine().getPower() > 250) {
                    System.out.println(e.getModel());
                }
            });
        }
    }
}
