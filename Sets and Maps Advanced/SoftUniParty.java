import java.sql.SQLOutput;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Set<String> vips = new LinkedHashSet<>();
        Set<String> regulars = new LinkedHashSet<>();

        while (!"PARTY".equals(input)) {
            if (Character.isDigit(input.charAt(0))) {
                vips.add(input);
            } else {
                regulars.add(input);
            }
            input = scan.nextLine();
        }

        input = scan.nextLine();

        TreeSet<String> allGuests = new TreeSet<>(vips);
        allGuests.addAll(regulars);

        while (!"END".equals(input)) {
            allGuests.remove(input);
            input = scan.nextLine();
        }

        System.out.println(allGuests.size());

        System.out.println(String.join(System.lineSeparator(), allGuests));
    }
}
