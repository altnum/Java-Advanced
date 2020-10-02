import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Double>> countries = new LinkedHashMap<>();

        String info = scan.nextLine();

        while (!"report".equals(info)) {
            String[] tokens = info.split("\\|");

            countries.putIfAbsent(tokens[1], new LinkedHashMap<>());
            countries.get(tokens[1]).putIfAbsent(tokens[0], 0.0);
            countries.get(tokens[1]).put(tokens[0], Double.parseDouble(tokens[2]));

            info = scan.nextLine();
        }

        countries
                .entrySet()
                .stream()
                .sorted((l, r) -> {
                    double totalLPopulation;
                    double totalRPopulation;

                    totalLPopulation = l.getValue()
                            .values()
                            .stream().mapToDouble(i -> i).sum();
                    totalRPopulation = r.getValue()
                            .values()
                            .stream().mapToDouble(i -> i).sum();

                    return Double.compare(totalRPopulation, totalLPopulation);
                })
                .forEach(e -> {
                    System.out.printf("%s (total population: %.0f)%n", e.getKey(), e.getValue()
                                                                                .values()
                                                                                .stream()
                                                                                .mapToDouble(i -> i).sum());
                    e.getValue()
                            .entrySet()
                            .stream()
                            .sorted((l, r) -> Double.compare(r.getValue(), l.getValue()))
                            .forEach(v -> System.out.printf("=>%s: %.0f%n", v.getKey(), v.getValue()));
                });
    }
}
