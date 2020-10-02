import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> venues = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("([A-Za-z\\s]+) @([A-Za-z0-9]+\\s?[A-Za-z0-9\\s]+)\\s([0-9]+)\\s([0-9]+)");

        String info = scan.nextLine();

        while (!"End".equals(info)) {
            Matcher matcher = pattern.matcher(info);
            while (matcher.find()) {
                String name = matcher.group(1);
                String venue = matcher.group(2);
                String price = matcher.group(3);
                String count = matcher.group(4);

                venues.putIfAbsent(venue, new LinkedHashMap<>());
                venues.get(venue).putIfAbsent(name, 0);
                venues.get(venue).put(name, venues.get(venue).get(name) + Integer.parseInt(price) * Integer.parseInt(count));
            }
            info = scan.nextLine();
        }

        venues
                .forEach((k, v) -> {
                    System.out.println(k);
                    v.entrySet()
                            .stream()
                            .sorted((l, r) -> Integer.compare(r.getValue(), l.getValue()))
                            .forEach(e -> System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue()));

                });
    }
}
