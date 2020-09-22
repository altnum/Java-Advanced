import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rotation = scan.nextLine();
        int angleRotation = Integer.parseInt(rotation.split("[()]+")[1]) % 360;

        String input = scan.nextLine();
        List<String> linesForMatrix = new ArrayList<>();
        int maxLength = input.length();

        while (!"END".equals(input)) {
            linesForMatrix.add(input);
            input = scan.nextLine();

            if (input.length() > maxLength)
                maxLength = input.length();
        }

        int rows = linesForMatrix.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j < linesForMatrix.get(i).length()) {
                    matrix[i][j] = linesForMatrix.get(i).charAt(j);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        rotate(angleRotation, rows, cols, matrix);
    }

    private static void rotate(int angleRotation, int rows, int cols, char[][] matrix) {
        if (angleRotation == 90) {
            for (int j = 0; j < cols; j++) {
                for (int i = rows - 1; i >= 0; i--) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        } else if (angleRotation == 180) {
            for (int i = rows - 1; i >= 0; i--) {
                for (int j = cols - 1; j >= 0 ; j--) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        } else if (angleRotation == 270) {
            for (int j = cols - 1; j >= 0; j--) {
                for (int i = 0; i < rows; i++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();

            }
        } else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
    }
}
