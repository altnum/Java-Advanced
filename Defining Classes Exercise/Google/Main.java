package Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Person> people = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] command = reader.readLine().split("\\s+");

        while(!"End".equals(command[0])) {
            switch (command[1]) {
                case "company":
                    people.putIfAbsent(command[0], new Person(command[0]));
                    Person p = people.get(command[0]);
                    p.setCompany(command[2], command[3], Double.parseDouble(command[4]));
                    break;
                case "pokemon":
                    people.putIfAbsent(command[0], new Person(command[0]));
                    Person v = people.get(command[0]);
                    v.setPokemon(command[2], command[3]);
                    break;
                case "parents":
                    people.putIfAbsent(command[0], new Person(command[0]));
                    Person k = people.get(command[0]);
                    k.setParents(k.getParents(), command[2], command[3]);
                    break;
                case "children":
                    people.putIfAbsent(command[0], new Person(command[0]));
                    Person c = people.get(command[0]);
                    c.setChildren(c.getChildren(), command[2], command[3]);
                    break;
                case "car":
                    people.putIfAbsent(command[0], new Person(command[0]));
                    Person x = people.get(command[0]);
                    x.setCar(command[2], Integer.parseInt(command[3]));
                    break;
            }
            command = reader.readLine().split("\\s+");
        }

        String name = reader.readLine();

        people.forEach((k, v) -> {
            if (name.equals(k)) {
                System.out.println(k);
                System.out.println("Company:");
                if (v.getCompany() != null)
                    System.out.printf("%s %s %.2f%n", v.getCompany().getName(), v.getCompany().getDepartment(), v.getCompany().getSalary());
                System.out.println("Car: ");
                if (v.getCar() != null)
                    System.out.printf("%s %d%n", v.getCar().getModel(), v.getCar().getSpeed());

                System.out.println("Pokemon: ");
                if (!v.getPokemon().isEmpty()) {
                    for (int i = 0; i < v.getPokemon().size(); i++) {
                        System.out.println(v.getPokemon().get(i).getName() + " " + v.getPokemon().get(i).getType());
                    }
                }

                System.out.println("Parents: ");
                if (!v.getParents().isEmpty()) {
                    for (int i = 0; i < v.getParents().size(); i++) {
                        System.out.println(v.getParents().get(i).getName() + " " + v.getParents().get(i).getBirthday());
                    }
                }

                System.out.println("Children: ");
                if (!v.getChildren().isEmpty()) {
                    for (int i = 0; i < v.getChildren().size(); i++) {
                        System.out.println(v.getChildren().get(i).getName() + " " + v.getChildren().get(i).getBirthday());
                    }
                }
            }

        });
    }
}
