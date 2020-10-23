package ExamPreparation;

import java.util.Scanner;

public class Snake {
    public static int food = 0;
    public static int rowSnake = 0;
    public static int colSnake = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        char[][] field = new char[n][n];

        for (int i = 0; i < n; i++) {
             String line = scan.nextLine();
             if (line.contains("S")) {
                 rowSnake = i;
                 colSnake = line.indexOf("S");
             }

            field[i] = line.toCharArray();
        }

        while (food < 10) {
            String command = scan.nextLine();

            if ("up".equals(command)) {
                //row - 1
                if (isOuOfBounds(rowSnake - 1, colSnake, field))
                    break;
                else {
                    if (!moveSnake(rowSnake, colSnake, rowSnake - 1, colSnake, field)) {
                        rowSnake--;
                    }
                }
            } else if ("down".equals(command)) {
                //row + 1
                if (isOuOfBounds(rowSnake + 1, colSnake, field))
                    break;
                else {
                    if (!moveSnake(rowSnake, colSnake, rowSnake + 1, colSnake, field)) {
                        rowSnake++;
                    }
                }
            } else if ("left".equals(command)) {
                //col - 1
                if (isOuOfBounds(rowSnake, colSnake - 1, field))
                    break;
                else {
                    if (!moveSnake(rowSnake, colSnake, rowSnake, colSnake - 1, field)) {
                        colSnake--;
                    }
                }
            } else if ("right".equals(command)) {
                //col + 1
                if (isOuOfBounds(rowSnake, colSnake + 1, field))
                    break;
                else {
                    if (!moveSnake(rowSnake, colSnake, rowSnake, colSnake + 1, field)) {
                        colSnake++;
                    }
                }
            }
        }

        if (food >= 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            field[rowSnake][colSnake] = '.';
            System.out.println("Game over!");
        }

        System.out.println("Food eaten: " + food);

        printMatrix(field);
    }


    private static boolean moveSnake(int oldRow, int oldCol, int newRow, int newCol, char[][] field) {
        if (field[newRow][newCol] == '-') {
            field[newRow][newCol] = 'S';
        } else if (field[newRow][newCol] == '*') {
            field[newRow][newCol] = 'S';
            food++;
        } else if (field[newRow][newCol] == 'B') {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] == 'B' && (i != newRow || j != newCol)) {
                        field[i][j] = 'S';
                        field[newRow][newCol] = '.';
                        field[oldRow][oldCol] = '.';
                        rowSnake = i;
                        colSnake = j;
                        return true;
                    }
                }
            }
        }
        field[oldRow][oldCol] = '.';
        return false;
    }

    private static boolean isOuOfBounds(int i, int colSnake, char[][] field) {
        return i < 0 || i >= field.length || colSnake < 0 || colSnake >= field[i].length;
    }

    private static void fillBurrowIndexes(int[] firstBurrowIndexes, int[] secondBurrowIndexes, int i, String line) {
        if (line.contains("B")) {
            if (firstBurrowIndexes[0] == -1) {
                firstBurrowIndexes[0] = i;
                firstBurrowIndexes[1] = line.indexOf("B");
            } else {
                secondBurrowIndexes[0] = i;
                secondBurrowIndexes[1] = line.indexOf("B");
            }
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
