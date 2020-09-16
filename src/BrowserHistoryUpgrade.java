import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String navigation = scan.nextLine();
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();
        String current = "";

        while (!navigation.equals("Home")) {
            if (navigation.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    navigation = scan.nextLine();
                    continue;
                } else {
                    forward.addFirst(current);
                    current = history.pop();
                }
            } else if ("forward".equals(navigation)) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                    navigation = scan.nextLine();
                    continue;
                } else {
                    history.push(current);
                    current = forward.poll();
                }
            } else {
                if (!current.isEmpty())
                    history.push(current);
                current = navigation;
                forward.clear();
            }
            System.out.println(current);
            navigation = scan.nextLine();
        }
    }
}