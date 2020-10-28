import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> prices = Arrays.stream(scanner.nextLine().split(", ")).map(Double::parseDouble).collect(Collectors.toList());
        UnaryOperator<Double> operator = w -> w * 1.2;

        System.out.println("Prices with VAT:");

        for (var d : prices) {
            d = operator.apply(d);
            System.out.printf("%.2f%n", d);
        }
    }
}
