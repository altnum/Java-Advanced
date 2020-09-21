import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[rows][];
        Map<String, Integer> coorAndValue = new LinkedHashMap<>();

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        String[] coorX = scan.nextLine().split("\\s+");
        int wrongValue = matrix[Integer.parseInt(coorX[0])][Integer.parseInt(coorX[1])];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == wrongValue) {
                    int sum = 0;
                    if (i != 0 && matrix[i - 1][j] != wrongValue) {
                        sum += matrix[i - 1][j];
                    }
                    if (i != rows - 1 && matrix[i + 1][j] != wrongValue) {
                        sum += matrix[i + 1][j];
                    }
                    if (j != 0 && matrix[i][j - 1] != wrongValue) {
                        sum += matrix[i][j - 1];
                    }
                    if (j != matrix[0].length - 1 && matrix[i][j + 1] != wrongValue) {
                        sum += matrix[i][j + 1];
                    }
                    coorAndValue.put(i + " " + j, sum);
                }
            }
        }
        for (Map.Entry<String, Integer> entry: coorAndValue.entrySet()) {
            String[] coors = entry.getKey().split(" ");
            matrix[Integer.parseInt(coors[0])][Integer.parseInt(coors[1])] = entry.getValue();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
