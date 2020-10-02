import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String resource = scan.nextLine();

        while (!"stop".equals(resource)) {
            int quantity = Integer.parseInt(scan.nextLine());

            if (resources.containsKey(resource)) {
                quantity += resources.get(resource);
            }
            resources.put(resource, quantity);

            resource = scan.nextLine();
        }

        resources.forEach((k, v) -> {
            System.out.printf("%s -> %d%n", k, v);
        });
    }
}
