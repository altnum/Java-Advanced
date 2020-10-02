import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        scan.nextLine();

        Set<String> set1 = new LinkedHashSet<>();
        Set<String> set2 = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            set1.add(scan.nextLine());
        }
        for (int i = 0; i < m; i++) {
            set2.add(scan.nextLine());
        }
        set1.forEach(e -> {
            if (set2.contains(e))
                System.out.print(e + " ");
        });
    }
}
