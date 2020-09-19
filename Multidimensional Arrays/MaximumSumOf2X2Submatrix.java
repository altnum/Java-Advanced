import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dimensions = scan.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);


        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            int[] line = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = line;
        }
        int maxValue = Integer.MIN_VALUE;
        int[][] best = new int[2][2];

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (currentSum > maxValue) {
                    maxValue = currentSum;
                    best[0][0] = matrix[row][col];
                    best[1][0] = matrix[row + 1][col];
                    best[0][1] = matrix[row][col + 1];
                    best[1][1] = matrix[row + 1][col + 1];
                }
            }
        }
        for (int i = 0; i < best.length; i++) {
            for (int j = 0; j < best.length; j++) {
                System.out.print(best[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(maxValue);

    }
}
