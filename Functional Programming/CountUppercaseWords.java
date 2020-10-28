import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        if (scanner.hasNext()) {
            text += scanner.nextLine();
        }

        Predicate<String> startsWithUpperCase = w -> Character.isUpperCase(w.charAt(0));

        List<String> words = Arrays.stream(text.split("\\s+"))
                .filter(startsWithUpperCase)
                .collect(Collectors.toList());

        System.out.println(words.size());

        words.forEach(System.out::println);
    }
}
