import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        Consumer<String[]> printer = namesArr -> {
            for (int i = 0; i < namesArr.length; i++) {
                System.out.println(namesArr[i]);
            }
        };
        printer.accept(names);
    }
}
