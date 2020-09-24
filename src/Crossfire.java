import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        int counter = 1;

        scan.nextLine();

        List<ArrayList<Integer>> matrix= new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int j = 0; j < cols; j++) {
                a.add(counter);
                //matrix.get(i).get(j) = counter;
                counter++;
            }
            matrix.add(a);
        }

        String command = scan.nextLine();

        while (!"Nuke it from orbit".equals(command)) {

            int[] info = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row =  info[0];
            int col = info[1];
            int radius = info[2];

            for (int i = row - radius; i <= row + radius; i++) {
                    if (i < matrix.size() && i >= 0 && col < matrix.get(i).size() && col >= 0 && i != row)
                        matrix.get(i).remove(col);
            }
            for (int i = col + radius; i >= col - radius; i--) {
                    if (row < matrix.size() && row >= 0 && i < matrix.get(row).size() && i >= 0)
                        matrix.get(row).remove(i);
            }

            for (int i = 0; i < rows; i++) {
                if (matrix.get(i).isEmpty()) {
                    matrix.remove(i);
                    rows--;
                    i--;
                }
            }

            command = scan.nextLine();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}