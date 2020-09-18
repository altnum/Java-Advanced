import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int num = Integer.parseInt(scanner.nextLine());

        ArrayList<int[]> indexes = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currNum = matrix[row][col];
                if (currNum == num) {
                    indexes.add(new int[] {row, col});
                }
            }
        }
        if (indexes.isEmpty())
            System.out.println("not found");
        else {
            for (int[] index: indexes) {
                System.out.println(index[0] + " " + index[1]);
            }
        }

    }
}
