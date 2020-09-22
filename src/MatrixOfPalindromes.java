import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            char two = (char) (i + 97);
            for (int j = 0; j < cols; j++) {
                char one = (char) (i + j + 97);
                matrix[i][j] = String.valueOf(two) + String.valueOf(one) + String.valueOf(two) + " ";
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
