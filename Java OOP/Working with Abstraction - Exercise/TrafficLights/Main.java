package TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] startColours = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());

        List<TrafficLight> trafficLights = new ArrayList<TrafficLight>();

        for (String light : startColours) {
            TrafficLight trafficLight = new TrafficLight(Colour.valueOf(light));
            trafficLights.add(trafficLight);
        }

        for (int i = 0; i < n; i++) {
            for (TrafficLight l : trafficLights) {
                l.update();
                System.out.print(l.getColour() + " ");
            }
            System.out.println();
        }
    }
}
