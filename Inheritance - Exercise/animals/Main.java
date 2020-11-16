package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        while(!command.equals("Beast!")) {
            String[] animalData = scan.nextLine().split("\\s+");
            String name = animalData[0];

            int age = Integer.parseInt(animalData[1]);
            try {
                if (age < 0) {
                    throw new IllegalArgumentException("Invalid input!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
                command = scan.nextLine();
                continue;
            }

            try {
                if (!animalData[2].equals("Male") && !animalData[2].equals("Female")) {
                    throw new IllegalArgumentException("Invalid gender!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid gender!");
                command = scan.nextLine();
                continue;
            }

            String gender = animalData[2];

            switch (command) {
                case "Frog":
                    Frog frog = new Frog(name, age, gender);
                    System.out.println(frog.toString());
                    break;
                case "Animals.Dog":
                    Dog dog = new Dog(name, age, gender);
                    System.out.println(dog.toString());
                    break;
                case "Animals.Cat":
                    Cat cat = new Cat(name, age, gender);
                    System.out.println(cat.toString());
                    break;
                case "Kitten":
                    Kitten kitten = new Kitten(name, age);
                    System.out.println(kitten.toString());
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(name, age);
                    System.out.println(tomcat.toString());
                    break;
            }
            command = scan.nextLine();
        }
    }
}
