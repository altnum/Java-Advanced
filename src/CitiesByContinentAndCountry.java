import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, Map<String, List<String>>> data = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            data.putIfAbsent(continent, new LinkedHashMap<>());
            data.get(continent).putIfAbsent(country, new ArrayList<>());
            data.get(continent).get(country).add(city);
        }

        data.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((innerKey, innerValue) -> {
                System.out.println("  " + innerKey + " -> " + String.join(", ", innerValue));
            });
        });
    }
}
