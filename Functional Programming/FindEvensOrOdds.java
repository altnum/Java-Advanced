import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = scanner.nextInt();
        int upperBound = scanner.nextInt();
        scanner.nextLine();
        String criteria = scanner.nextLine();
        List<Integer> nums = new ArrayList<>();
        for (int i = lowerBound; i <= upperBound; i++) {
            nums.add(i);
        }
        Predicate<Integer> filter = createFilter(criteria);
        nums
                .stream()
                .filter(filter)
                .forEach(n -> System.out.print(n  + " "));

    }

    private static Predicate<Integer> createFilter(String criteria) {
        if ("even".equals(criteria)) {
            return n -> n % 2 == 0;
        }
        return n -> n % 2 != 0;
    }
}
