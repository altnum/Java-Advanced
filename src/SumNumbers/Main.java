package SumNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] nums = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], String> getCountStr = arr -> String.format("Count = %d", arr.length);
        System.out.println(getCountStr.apply(nums));

        Function<int[], String> getSum = arr -> "Sum = " + Arrays.stream(arr).sum();
        System.out.println(getSum.apply(nums));
    }
}
