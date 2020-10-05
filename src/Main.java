import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Car car;
        for (int i = 0; i < n; i++) {
            String[] info = scan.nextLine().split("\\s+");
            if (info.length == 1)
                car = new Car(info[0]);
            else
                car = new Car(info[0], info[1], Integer.parseInt(info[2]));
            System.out.printf("The car is: %s %s - %d HP.%n", car.getBrand(), car.getModel(), car.getHorsepower());
        }


    }
}
