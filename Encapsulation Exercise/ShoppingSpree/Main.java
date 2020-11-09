package ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = Arrays.stream(scanner.nextLine()
                                                .split(";"))
                                                .map(personInfo -> {
                                                    String[] tokens = personInfo.split("=");
                                                    try {
                                                        return new Person(tokens[0], Double.parseDouble(tokens[1]));
                                                    } catch (IllegalArgumentException ex) {
                                                        System.out.println(ex.getMessage());
                                                    }

                                                    return null;
                                                })
                                                .collect(Collectors.toList());
        List<Product> products = Arrays.stream(scanner.nextLine()
                .split(";"))
                .map(personInfo -> {
                    String[] tokens = personInfo.split("=");
                    try {
                        return new Product(tokens[0], Double.parseDouble(tokens[1]));
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                    return null;
                })
                .collect(Collectors.toList());

        if (people.stream().anyMatch(Objects::isNull) || products.stream().anyMatch(Objects::isNull))
            return;

        String input = scanner.nextLine();

        while(!input.equals("END")) {
            String[] tokens = input.split("\\s+");


            String personName = tokens[0];
            String product = tokens[1];

            for (Person p : people) {
                if (p.getName().equals(p)) {
                    try {
                        Product productToBuy = products.stream()
                                .filter(per -> per.getName().equals(product))
                                .findFirst()
                                .orElseThrow(Exception::new);

                        p.buyProduct(productToBuy);
                        System.out.println(p + " bought " + product);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                }
            input = scanner.nextLine();
        }

        for (Person p : people) {
            System.out.println(p.toString());
        }


    }
}
