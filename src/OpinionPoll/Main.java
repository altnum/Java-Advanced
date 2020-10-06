package OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> people = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] info = scan.nextLine().split("\\s+");
            Person person = new Person(info[0], Integer.parseInt(info[1]));
            people.put(person.getName(), person.getAge());
        }

        people.entrySet()
                .stream()
                .filter(e -> e.getValue() > 30)
                .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));
    }
}
