import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> users = new TreeMap<>();

        int n = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < n; i++) {
            String[] info = scan.nextLine().split("\\s+");

            users.putIfAbsent(info[1], new TreeMap<>());
            users.get(info[1]).putIfAbsent(info[0], 0);

            int curr = users.get(info[1]).get(info[0]);
            users.get(info[1]).put(info[0], curr + Integer.parseInt(info[2]));
        }

        users.forEach((key, value) -> {
            System.out.print(key + ": ");

            int time = value
                    .values()
                    .stream()
                    .mapToInt(i -> i).sum();
            System.out.print(time + " [");

            List<String> ips = new ArrayList<>(value
                    .keySet());

            System.out.print(String.join(", ", ips));
            System.out.println("]");
        });
    }
}
