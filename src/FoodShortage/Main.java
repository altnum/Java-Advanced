package FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        List<String> names = new ArrayList<>();
        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            switch (tokens.length) {
                case 4:
                    Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
                    if (!names.contains(tokens[0])) {
                        names.add(tokens[0]);
                        citizens.add(citizen);
                    }
                    break;
                case 3:
                    Rebel rebel = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                    if (!names.contains(tokens[0])) {
                        names.add(tokens[0]);
                        rebels.add(rebel);
                    }
                    break;
            }
        }

        String command = scan.nextLine();
        int purchasedFood = 0;

        label1:
        while(!"End".equals(command)) {
            if (names.contains(command)) {
                for (Citizen c : citizens) {
                    if (c.getName().equals(command)) {
                        c.buyFood();
                        purchasedFood += 10;
                        command = scan.nextLine();
                        continue label1;
                    }
                }

                for (Rebel r : rebels) {
                    if (r.getName().equals(command)) {
                        r.buyFood();
                        purchasedFood += 5;
                        command = scan.nextLine();
                        continue label1;
                    }
                }
            }

            command = scan.nextLine();
        }

        System.out.println(purchasedFood);
    }
}
