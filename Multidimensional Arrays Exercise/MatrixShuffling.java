import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();

        scan.nextLine();

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }

        String command = scan.nextLine();

        while (!"END".equals(command)) {
            String[] tokens = command.split("\\s+");

            if (tokens.length != 5) {
                System.out.println("Invalid input!");
                command = scan.nextLine();
                continue;
            } else {

                try {
                    String h = matrix[Integer.parseInt(tokens[1])][Integer.parseInt(tokens[2])];
                    matrix[Integer.parseInt(tokens[1])][Integer.parseInt(tokens[2])] = matrix[Integer.parseInt(tokens[3])][Integer.parseInt(tokens[4])];
                    matrix[Integer.parseInt(tokens[3])][Integer.parseInt(tokens[4])] = h;
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                    command = scan.nextLine();
                    continue;
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            command = scan.nextLine();
        }
    }
}
