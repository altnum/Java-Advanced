package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] info = scanner.nextLine().split("\\s+");

        String inputSeason = info[2];
        String inputDiscount = info[3];

        Season season = Season.valueOf(inputSeason.toUpperCase());
        Discount discount = Discount.valueOf(inputDiscount.toUpperCase());
        PriceCalculator priceCalculator = new PriceCalculator(season, discount, Double.parseDouble(info[0]), Integer.parseInt(info[1]));

        System.out.printf("%.2f", priceCalculator.calculatePrice());
    }

}
