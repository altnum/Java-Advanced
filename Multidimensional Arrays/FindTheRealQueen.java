import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[][] chessboard = new String[8][8];

        for (int i = 0; i < chessboard.length; i++) {
            chessboard[i] = scan.nextLine().split("\\s+");
        }

        boolean q = false;
        int rows = 0;
        int cols = 0;

        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard.length; j++) {
                if ("q".equals(chessboard[i][j])) {
                    if (realQueen(chessboard, i, j)) {
                        q = true;
                        rows = i;
                        cols = j;
                        break;
                    }
                }
            }
            if (q)
                break;
        }

        if (q)
            System.out.println(rows + " " + cols);
    }

    private static boolean realQueen(String[][] chessboard, int row, int col) {
        if (row != 0) {
            for (int i = row - 1; i >= 0; i--) {
                if ("q".equals(String.valueOf(chessboard[i][col])))
                    return false;
            }
        }
        if (row != chessboard.length - 1) {
            for (int i = row + 1; i < chessboard.length; i++) {
                if ("q".equals(String.valueOf(chessboard[i][col])))
                    return false;
            }
        }
        if (col != 0) {
            for (int i = col - 1; i >= 0; i--) {
                if ("q".equals(String.valueOf(chessboard[row][i])))
                    return false;
            }
        }
        if (col != chessboard.length - 1) {
            for (int i = col + 1; i < chessboard.length; i++) {
                if ("q".equals(String.valueOf(chessboard[row][i])))
                    return false;
            }
        }
        if (row != 0 && col != 0) {
            int i = row;
            int j = col;
            while (i > 0 && j > 0) {
                i--;
                j--;
                if ("q".equals(String.valueOf(chessboard[i][j])))
                    return false;
            }
        }
        if (row != chessboard.length && col != 0) {
            int i = row;
            int j = col;
            while (i < chessboard.length - 1 && j > 0) {
                i++;
                j--;
                if ("q".equals(String.valueOf(chessboard[i][j])))
                    return false;
            }
        }
        if (row != 0 && col != chessboard.length) {
            int i = row;
            int j = col;
            while (i > 0 && j < chessboard.length - 1) {
                i--;
                j++;
                if ("q".equals(String.valueOf(chessboard[i][j])))
                    return false;
            }
        }
        if (row != chessboard.length && col != chessboard.length) {
            int i = row;
            int j = col;
            while (i < chessboard.length - 1 && j < chessboard.length - 1) {
                i++;
                j++;
                if ("q".equals(String.valueOf(chessboard[i][j])))
                    return false;
            }
        }
        return true;
    }
}
