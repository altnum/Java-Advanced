import java.util.ArrayDeque;
import java.util.Scanner;

public class JA1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String navigation = scan.nextLine();
        ArrayDeque<String> history = new ArrayDeque<>();
        String current = "";

        while (!navigation.equals("Home")) {
            if (navigation.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    navigation = scan.nextLine();
                    continue;
                } else {
                    current = history.pop();
                }
            } else {
                if (!current.isEmpty())
                    history.push(current);
                current = navigation;
            }
            navigation = scan.nextLine();
            System.out.println(current);
        }
    }
}
