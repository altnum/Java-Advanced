import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputRobots = scanner.nextLine().split(";");
        String[] robotNames = new String[inputRobots.length];
        int[] robotTime = new int[inputRobots.length];

        for (int i = 0; i < inputRobots.length; i++) {
            String[] robotInfo = inputRobots[i].split("-");
            robotNames[i] = robotInfo[0];
            robotTime[i] = Integer.parseInt(robotInfo[1]);
        }

        String time = scanner.nextLine();
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        int seconds = Integer.parseInt(time.split(":")[2]);

        long totalTimeInSeconds = hours * 3600 + minutes * 60 + seconds;
        String product = scanner.nextLine();
        ArrayDeque<String> products = new ArrayDeque<>();
        int[] workingTime = new int[robotTime.length];

        while (!"End".equals(product)) {
            products.offer(product);
            product = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            totalTimeInSeconds++;
            boolean isAssigned = false;

            for (int i = 0; i < workingTime.length; i++) {
                if (workingTime[i] > 0) {
                    --workingTime[i];
                }
            }
            for (int i = 0; i < workingTime.length; i++) {
                if (workingTime[i] == 0) {
                    int count = 0;
                    for (int robot: robotTime) {
                        if (count == i) {
                            workingTime[i] = robot;
                            long takenHour = totalTimeInSeconds / 3600 % 24;
                            long takenMinutes = totalTimeInSeconds % 3600 / 60;
                            long takenSeconds = totalTimeInSeconds % 60;
                            System.out.printf("%s - %s [%02d:%02d:%02d]%n", robotNames[count], currentProduct, takenHour, takenMinutes, takenSeconds);
                            isAssigned = true;
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }
            if (!isAssigned) {
                products.offer(currentProduct);
            }
        }

    }
}
