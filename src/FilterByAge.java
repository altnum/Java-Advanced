import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {
    public static class Person {
        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            people.add(person);
        }

        String criteria = scanner.nextLine();
        int ageCriteria = Integer.parseInt(scanner.nextLine());

        Predicate<Person> ageFilter = createAgeFilter(criteria, ageCriteria);
        String formatOption = scanner.nextLine();
        Function<Person, String> formatter = createFormatter(formatOption);

        String output = people.stream()
                .filter(ageFilter)
                .map(formatter)
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(output);
    }

    private static Function<Person, String> createFormatter(String formatOption) {
        if ("name".equals(formatOption)) {
            return p -> p.name;
        } else if ("age".equals(formatOption)) {
            return p -> String.valueOf(p.age);
        } else {
            return p -> p.name + " - " + p.age;
        }
    }

    private static Predicate<Person> createAgeFilter(String criteria, int ageCriteria) {
        if ("older".equals(criteria)) {
            return p -> p.age >= ageCriteria;
        }
        return p -> p.age <= ageCriteria;
    }
}
