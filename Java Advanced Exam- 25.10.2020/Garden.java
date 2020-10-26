import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Garden {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] garden = new int[dimensions[0]][dimensions[1]];

        String command = reader.readLine();

        while(!"Bloom Bloom Plow".equals(command)) {
            int[] coordinates = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            boolean outOfGarden = outOfBounds(coordinates[0], coordinates[1], garden);

            if (outOfGarden) {
                System.out.println("Invalid coordinates.");
                command = reader.readLine();
                continue;
            }

            bloom(coordinates[0], coordinates[1], garden);
            command = reader.readLine();
        }

        printGarden(garden);

    }

    private static void printGarden(int[][] garden) {
        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[0].length; j++) {
                System.out.print(garden[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bloom(int row, int col, int[][] garden) {
        for (int i = 0; i < garden[row].length; i++) {
            garden[row][i] += 1;
        }

        for (int i = 0; i < garden.length; i++) {
            if (i == row)
                continue;
            garden[i][col] += 1;
        }
    }

    private static boolean outOfBounds(int row, int col, int[][] garden) {
        return row >= garden.length || row < 0 || col >= garden[0].length || col < 0;
    }
}
