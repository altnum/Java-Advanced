import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();

        scan.nextLine();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            maze[i] = scan.nextLine().split("\\s+");
        }

        String fillChar = scan.nextLine();

        int startRow = scan.nextInt();
        int startCol = scan.nextInt();

        String startChar = maze[startRow][startCol];

        fill(startRow, startCol, maze, fillChar, startChar);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean fill(int x, int y, String[][] maze, String fillChar, String startChar) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            return false;
        }
        if (!startChar.equals(maze[x][y]))
            return false;
        maze[x][y] = fillChar;
        if (fill(x - 1, y, maze, fillChar, startChar))
            return true;
        if (fill(x, y + 1, maze, fillChar, startChar))
            return true;
        if (fill(x + 1, y, maze, fillChar, startChar))
            return true;
        if (fill(x, y - 1, maze, fillChar, startChar))
            return true;
        return false;
    }
}
