import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class two {
    public static void main(String []args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, ArrayList<List<Double>>> plants = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] info = scan.nextLine().split("<->");
            String name = info[0];
            Integer rarity = Integer.parseInt(info[1]);

            plants.putIfAbsent(name, new ArrayList<List<Double>>(2));
            plants.get(name).add(0, new LinkedList<>());
            plants.get(name).add(0, new LinkedList<>());
            if (plants.containsKey(name)) {
                plants.get(name).get(0).add(Double.valueOf(rarity));
            }
        }

        String command = scan.nextLine();
        boolean error = true;

        while (!"Exhibition".equals(command)) {
            String[] info = command.split("\\s+");

            if ("Rate:".equals(info[0])) {
                if (plants.containsKey(info[0])) {
                    plants.get(info[1]).get(1).add((double) Integer.parseInt(info[3]));
                } else {
                    error = true;
                    System.out.println("error");
                }
            } else if ("Update:".equals(info[0])) {
                if (plants.containsKey(info[0])) {
                    plants.get(info[1]).get(0).set(0, (double) Integer.parseInt(info[3]));
                } else {
                    error = true;
                    System.out.println("error");
                }
            } else if ("Reset:".equals(info[0])) {
                if (plants.containsKey(info[0])) {
                    plants.get(info[1]).get(1).clear();
                    plants.get(info[1]).set(1, new LinkedList<>());
                } else {
                    error = true;
                    System.out.println("error");
                }
            } else {
                if (!error)
                    System.out.println("error");
            }

            command = scan.nextLine();
            error = false;
        }

        System.out.println("Plants for the exhibition:");
        plants
                .entrySet()
                .stream()
                .sorted((l, r) -> {
                    int res = Double.compare(r.getValue().get(0).get(0), l.getValue().get(0).get(0));

                    if (res == 0) {
                        return Double.compare(r.getValue().get(1).stream().mapToDouble(a -> a).average().orElse(0.0), l.getValue().get(1).stream().mapToDouble(a -> a).average().orElse(0.0));
                    }

                    return res;
                })
                .forEach(e -> {

                    System.out.print(String.format("- %s; Rarity: %.0f; Rating: %.2f%n", e.getKey(), e.getValue().get(0).get(0), e.getValue().get(1).stream().mapToDouble(a -> a).average().orElse(0.0)));
                });
    }
}
