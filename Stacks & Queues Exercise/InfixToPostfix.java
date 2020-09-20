import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] expression = scan.nextLine().split("\\s+");
        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorsStack = new ArrayDeque<>();

        for (int i = 0; i < expression.length; i++) {
            String token = String.valueOf(expression[i]);

            if ("+".equals(token) || "-".equals(token)) {
                while (!operatorsStack.isEmpty() && !"(".equals(operatorsStack.peek())) {
                          outputQueue.offer(operatorsStack.pop());
                }
                operatorsStack.push(token);
            } else if ("*".equals(token) || "/".equals(token)) {
                if ("*".equals(operatorsStack.peek()) || "/".equals(operatorsStack.peek())) {
                    outputQueue.offer(operatorsStack.pop());
                    operatorsStack.push(token);
                } else {
                    operatorsStack.push(token);
                }
            } else if ("(".equals(token))
                operatorsStack.push(token);
            else if (")".equals(token)) {
                while (!"(".equals(operatorsStack.peek())) {
                    outputQueue.offer(operatorsStack.pop());
                }
                if ("(".equals(operatorsStack.peek()))
                    operatorsStack.pop();
            } else {
                outputQueue.offer(token);
            }
        }
        while (!operatorsStack.isEmpty()) {
            outputQueue.offer(operatorsStack.pop());
        }

        while (!outputQueue.isEmpty()) {
            System.out.print(outputQueue.poll() + " ");
        }
    }
}
