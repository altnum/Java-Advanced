import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();

        Map<String, Map<String, Double>> costs = new TreeMap<>();

        while (!"Revision".equals(line)) {
            String[] tokens = line.split(", ");

            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            costs.putIfAbsent(shop, new LinkedHashMap<>());

            costs.get(shop).put(product, price);


            line = scan.nextLine();
        }

        costs.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + "->");
                    entry.getValue().entrySet()
                            .stream()
                            .forEach(innerEntry -> {
                                System.out.printf("Product: %s, Price: %.1f%n",
                                        innerEntry.getKey(), innerEntry.getValue());
                            });
                });
    }
}