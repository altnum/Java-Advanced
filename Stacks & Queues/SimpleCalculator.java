import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] actions = scan.nextLine().split("\\s+");

        for (int i = 0; i < actions.length; i++) {
            if ("+".equals(actions[i])) {
                i++;
                stack.push(Integer.parseInt(actions[i]));
            }
            else if ("-".equals(actions[i])) {
                i++;
                stack.push(Integer.parseInt(actions[i]) * -1);
            }
            else {
                stack.push(Integer.parseInt(actions[i]));
            }
        }
        int sum = 0;

        while (!stack.isEmpty()) {
            int n = stack.pop();
            sum += n;
        }

        System.out.println(sum);
    }
}
