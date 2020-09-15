import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expression = scan.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            if (symbol == '(') {
                stack.push(i);
            } else if (symbol == ')'){
                int openingIndex = stack.pop();
                int closingIndex = i;
                System.out.println(expression.substring(openingIndex, closingIndex + 1));
            }

        }
    }
}
