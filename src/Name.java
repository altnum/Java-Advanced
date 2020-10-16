import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class Name {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AtomicInteger sum = new AtomicInteger();

        BiConsumer<Integer, int[]> biFunction =
                (e, count) -> {
                    sum.addAndGet(e);
                    ++count[0];
                };
        int[] count = new int[1];

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(e -> biFunction.accept(e, count));

        System.out.println(count[0]);
        System.out.println(sum.get());
    }
}
