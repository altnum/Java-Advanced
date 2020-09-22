import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] info = scan.nextLine().split(", ");
        int size = Integer.parseInt(info[0]);
        String pattern = info[1];

        int[][] matrix = Type(size, pattern);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] Type(int size, String pattern) {
        int[][] matrix = new int[size][size];
        int count = 0;
        
        if ("A".equals(pattern)) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    count++;
                    matrix[j][i] = count;
                }
            }
        } else if ("B".equals(pattern)) {
                for (int i = 0; i < size; i++) {
                    if (i % 2 == 0) {
                        for (int j = 0; j < size; j++) {
                            count++;
                            matrix[j][i] = count;
                        }
                    } else {
                        for (int j = matrix.length - 1; j >= 0; j--) {
                            count++;
                            matrix[j][i] = count;
                        }
                    }
                }
        }
        return matrix;
    }
}
