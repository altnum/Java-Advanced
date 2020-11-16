package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        List<Citizen> citizens = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();

        while(!"End".equals(command)) {
            String[] tokens = command.split("\\s+");
            String nameOfClass = tokens[0];

            switch (nameOfClass) {
                case "BirthdayCelebrations.FoodShortage.Citizen":
                    Citizen citizen = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                    citizens.add(citizen);
                    break;
                case "BirthdayCelebrations.Robot":
                    break;
                case "BirthdayCelebrations.Pet":
                    Pet pet = new Pet(tokens[1], tokens[2]);
                    pets.add(pet);
                    break;
            }

            command = scan.nextLine();
        }

        command = scan.nextLine();

        for (Citizen c : citizens) {
            String year = c.getBirthDate().split("/")[2];


            if (year.equals(command)) {
                System.out.println(c.getBirthDate());
            }
        }

        for (Pet p : pets) {
            String year = p.getBirthDate().split("/")[2];


            if (year.equals(command)) {
                System.out.println(p.getBirthDate());
            }
        }


    }
}
