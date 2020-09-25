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
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = arr[j];
            }
        }

        boolean wrote = false;

        for (int q = 0; q < matrix.length; q++) {
            int j = matrix.length - 1 - q;
            wrote = false;
            for (int i = matrix.length - 1; i >= matrix.length - 1 - q; i--) {
                    if (matrix[i][j] == 0) {
                        j++;
                        continue;
                    }
                    System.out.print(matrix[i][j] + " ");
                    wrote = true;
                    j++;
            }
            if (wrote)
                System.out.println();
        }

        for (int q = 0; q < matrix.length - 1; q++) {
            int i = matrix.length - 2 - q;
            wrote = false;
            for (int j = 0; j < matrix.length - 1 - q; j++) {
                if (matrix[i][j] == 0) {
                    i--;
                    continue;
                }
                System.out.print(matrix[i][j] + " ");
                wrote = true;
                i--;
            }
            if (wrote)
                System.out.println();
        }

    }
}