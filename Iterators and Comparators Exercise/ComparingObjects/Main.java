package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input = scan.nextLine();

        while (!"END".equals(input)) {
            String[] info = input.split("\\s+");
            Person person = new Person(info[0], Integer.parseInt(info[1]), info[2]);
            people.add(person);

            input = scan.nextLine();
        }

        int n = Integer.parseInt(scan.nextLine());
        Person personForCompare = people.get(n - 1);
        int countEqual = 0;

        for (Person person: people) {
            if (personForCompare.compareTo(person) == 0) {
                countEqual++;
            }
        }

        if (countEqual == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(countEqual + " " + (people.size() - countEqual) + " " + (people.size()));
        }
    }
}
