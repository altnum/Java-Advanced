import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("IP=(.*)\\smessage='(.*)' user=(.*)");
        Map<String, Map<String, Integer>> users = new TreeMap<>();
        String command = scan.nextLine();

        while (!"end".equals(command)) {
            Matcher matcher = pattern.matcher(command);
            String username = "";
            String IP = "";

            while (matcher.find()) {
                username = matcher.group(3);
                IP = matcher.group(1);

                users.putIfAbsent(username, new LinkedHashMap<>());
                users.get(username).putIfAbsent(IP, 0);
                int curr = users.get(username).get(IP);
                users.get(username).put(IP, ++curr);
            }

            command = scan.nextLine();
        }

        users
                .entrySet()
                .forEach(e -> {
                    System.out.println(e.getKey() + ":");
                    AtomicInteger count = new AtomicInteger();
                    e.getValue()
                            .entrySet()
                            .forEach(v -> {
                                if (e.getValue().size() == 1 || count.get() == e.getValue().size() - 1)
                                    System.out.printf("%s => %d.%n", v.getKey(), v.getValue());
                                else
                                    System.out.printf("%s => %d, ", v.getKey(), v.getValue());
                                count.getAndIncrement();
                            });
                });
    }
}
