import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        int allRows = Math.max(rows, cols);

        int[][] matrix = new int[allRows][allRows];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        //
        for (int q = 2; q <= matrix.length; q++) {
            for (int i = matrix.length - q; i >= 0; i--) {
                for (int j = 0; j <= matrix.length - q; j++) {
                    System.out.println(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
        //
        for (int q = 0; q < matrix.length; q++) {
            for (int i = matrix.length - 1; i >= q; i--) {
                for (int j = q; j < matrix.length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
        //...

    }
}
