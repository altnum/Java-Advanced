import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> contacts = new HashMap<>();
        String[] info = scan.nextLine().split("-");

        while (!"search".equals(info[0])) {
            contacts.put(info[0], info[1]);

            info = scan.nextLine().split("-");
        }

        String name = scan.nextLine();

        while (!"stop".equals(name)) {
            if (contacts.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, contacts.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }

            name = scan.nextLine();
        }
    }
}
