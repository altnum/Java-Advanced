import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        scan.nextLine();

        int[][] matrix = new int[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = 0;
        int[][] maxM = new int[3][3];

        for (int i = 1; i < n - 1; i++) {
            int sum = 0;
            int[][] currM = new int[3][3];

            for (int j = 1; j < m - 1; j++) {
                sum = matrix[i][j] + matrix[i - 1][j] + matrix[i + 1][j] +
                        matrix[i][j - 1] + matrix[i][j + 1] +
                        matrix[i - 1][j - 1] + matrix[i + 1][j + 1] +
                        matrix[i - 1][j + 1] + matrix[i + 1][j - 1];

                if (sum > maxSum) {
                    maxSum = sum;
                } else {
                    continue;
                }

                currM[0][0] = matrix[i - 1][j - 1];
                currM[0][1] = matrix[i - 1][j];
                currM[0][2] = matrix[i - 1][j + 1];
                currM[1][0] = matrix[i][j - 1];
                currM[1][1] = matrix[i][j];
                currM[1][2] = matrix[i][j + 1];
                currM[2][0] = matrix[i + 1][j - 1];
                currM[2][1] = matrix[i + 1][j];
                currM[2][2] = matrix[i + 1][j + 1];

                maxM = currM;


            }

        }

        System.out.println("Sum = " + maxSum);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(maxM[i][j] + " ");
            }
            System.out.println();
        }
    }
}