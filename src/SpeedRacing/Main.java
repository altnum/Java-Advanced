package SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Car> carsToTrack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split("\\s+");
            carsToTrack.add(new Car(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2])));
        }
        String command = reader.readLine();

        while (!"End".equals(command)) {
            String[] tokens = command.split("\\s+");
            int distance = Integer.parseInt(tokens[2]);

            for (Car c : carsToTrack) {
                if (tokens[1].equals(c.getModel())) {
                    if (c.CanTravel(distance)) {
                        c.setFuelAmount(distance);
                        c.setDistance(distance);
                    }
                }
            }

            command = reader.readLine();
        }

        reader.close();

        carsToTrack
                .forEach(e -> {
                    System.out.printf("%s %.2f %d%n", e.getModel(), e.getFuelAmount(), e.getDistance());
                });
    }
}
