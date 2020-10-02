import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("[A-Za-z0-9]+@[A-Za-z0-9]+.(?<group>[A-Za-z]+)");
        String name = scan.nextLine();
        String table = "ukuscom";

        while (!"stop".equals(name)) {
            String email = scan.nextLine();
            Matcher matcher = pattern.matcher(email);
            String end = "";

            while (matcher.find()) {
                end = matcher.group("group");
            }

            if (!table.contains(end)) {
                emails.put(name, email);
            }

            name = scan.nextLine();
        }

        emails.forEach((k, v) -> {
            System.out.printf("%s -> %s%n", k, v);
        });
    }
}
