import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Re_Volt {
    public static int playerRowI = -1;
    public static int playerColI = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[][] matrix = new String[n][n];

        int commandsCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < matrix.length; i++) {
            char[] line = reader.readLine().toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = String.valueOf(line[j]);

                if ("f".equals(matrix[i][j])) {
                    playerRowI = i;
                    playerColI = j;
                }
            }
        }

        boolean finishMark = false;

        for (int i = 0; i < commandsCount; i++) {
            String command = reader.readLine();
            finishMark = false;

            switch (command) {
                case "right":
                    finishMark = move(playerRowI, playerColI, playerRowI, playerColI + 1, matrix, command);
                    break;
                case "up":
                    finishMark = move(playerRowI, playerColI, playerRowI - 1, playerColI, matrix, command);
                    break;
                case "left":
                    finishMark = move(playerRowI, playerColI, playerRowI, playerColI - 1, matrix, command);
                    break;
                case "down":
                    finishMark = move(playerRowI, playerColI, playerRowI + 1, playerColI, matrix, command);
                    break;
            }

            if (finishMark) {
                System.out.println("Player won!");
                break;
            }
        }

        if (!finishMark)
            System.out.println("Player lost!");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean move(int playerRow, int playerCol, int newPLayerRow, int newPlayerCol, String[][] matrix, String direction) {
        if (!matrix[playerRow][playerCol].equals("B"))
            matrix[playerRow][playerCol] = "-";

        if (newPLayerRow >= matrix.length) {
            newPLayerRow = 0;
            if ("T".equals(matrix[newPLayerRow][newPlayerCol])) {
                newPLayerRow = matrix.length - 1;
                matrix[newPLayerRow][newPlayerCol] = "f";
                playerRowI = newPLayerRow;
                playerColI = newPlayerCol;
                return false;
            }
        } else if (newPlayerCol >= matrix[0].length) {
            newPlayerCol = 0;
            if ("T".equals(matrix[newPLayerRow][newPlayerCol])) {
                newPlayerCol = matrix[0].length - 1;
                matrix[newPLayerRow][newPlayerCol] = "f";
                playerRowI = newPLayerRow;
                playerColI = newPlayerCol;
                return false;
            }
        } else if (newPLayerRow < 0) {
            newPLayerRow = matrix.length - 1;
            if ("T".equals(matrix[newPLayerRow][newPlayerCol])) {
                newPLayerRow = 0;
                matrix[newPLayerRow][newPlayerCol] = "f";
                playerRowI = newPLayerRow;
                playerColI = newPlayerCol;
                return false;
            }
        } else if (newPlayerCol < 0) {
            newPlayerCol = matrix[0].length - 1;
            if ("T".equals(matrix[newPLayerRow][newPlayerCol])) {
                newPlayerCol = 0;
                matrix[newPLayerRow][newPlayerCol] = "f";
                playerRowI = newPLayerRow;
                playerColI = newPlayerCol;
                return false;
            }
        }

        if (matrix[newPLayerRow][newPlayerCol].equals("F")) {
            matrix[newPLayerRow][newPlayerCol] = "f";
            playerRowI = newPLayerRow;
            playerColI = newPlayerCol;
            return true;
        } else if ("B".equals(matrix[newPLayerRow][newPlayerCol])) {

            switch (direction) {
                case "right":
                    return move(newPLayerRow, newPlayerCol, newPLayerRow, newPlayerCol + 1, matrix, "right");
                case "up":
                    return move(newPLayerRow, newPlayerCol, newPLayerRow - 1, newPlayerCol, matrix, "up");
                case "left":
                    return move(newPLayerRow, newPlayerCol, newPLayerRow, newPlayerCol - 1, matrix, "left");
                case "down":
                    return move(newPLayerRow, newPlayerCol, newPLayerRow + 1, newPlayerCol, matrix, "down");
            }
        } else if ("-".equals(matrix[newPLayerRow][newPlayerCol])) {
            matrix[newPLayerRow][newPlayerCol] = "f";
            playerRowI = newPLayerRow;
            playerColI = newPlayerCol;
            return false;
        } else if ("T".equals(matrix[newPLayerRow][newPlayerCol])) {
            matrix[playerRow][playerCol] = "f";
            playerRowI = playerRow;
            playerColI = playerCol;
            return false;
        }

        return false;
    }
}
