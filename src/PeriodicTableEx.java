import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTableEx {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeSet<String> chemicalElements = new TreeSet<>();

        int n = Integer.parseInt(scan.next());

        for (int i = 0; i < n; i++) {
            String[] elements = scan.nextLine().split("\\s+");
            chemicalElements.addAll(Arrays.asList(elements));
        }

        System.out.println(String.join(" ", chemicalElements));
    }
}
