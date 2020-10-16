package SortEvenNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] str = scan.nextLine().split(", ");

        String output = Arrays.stream(str)
                .mapToInt(Integer::valueOf)
                .filter(num -> num % 2 == 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(output);

        output = Arrays.stream(str)
                .mapToInt(Integer::parseInt)
                .sorted()
                .boxed()
                .filter(num -> num % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(output);
    }

    private static void printSol(String[] str) {
        for (int i = 0; i < str.length; i++) {
            int num = Integer.parseInt(str[i]);
                    if (num % 2 == 0)
                        System.out.println(num);
        }

        Arrays.sort(str);

        for (int i = 0; i < str.length; i++) {
            int num = Integer.parseInt(str[i]);
            if (num % 2 == 0)
                System.out.println(num);
        }
    }
}
