import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        while (!"END".equals(input)) {
            int indexOf = input.indexOf(", ");
            String command = input.substring(0, indexOf);
            String registrationPlate = input.substring(indexOf + 2);

            if (command.equals("IN")) {
                parkingLot.add(registrationPlate);
            } else {
                parkingLot.remove(registrationPlate);
            }
            input = scan.nextLine();
        }
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), parkingLot));
        }
    }
}
