import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countCommands = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < countCommands; i++) {
            String[] command = scan.nextLine().split("\\s+");
            int numOfCommand = Integer.parseInt(command[0]);
            switch (numOfCommand) {
                case 1:
                    stack.push(Integer.parseInt(command[1]));
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(Collections.max(stack));
                    break;
                default:
                    break;
            }
        }
    }
}
