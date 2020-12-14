package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scan.nextLine());

        Rectangle rectangle = new Rectangle(
                new Point(coordinates[0], coordinates[1]),
                new Point(coordinates[2], coordinates[3])
        );

        for (int i = 0; i < n; i++) {
            int[] coordinates2 = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Point currPoint = new Point(coordinates2[0], coordinates2[1]);
            System.out.println(rectangle.contains(currPoint));
        }
    }
}
