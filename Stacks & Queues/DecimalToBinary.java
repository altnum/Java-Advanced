import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String str = scan.nextLine();
        if (Integer.parseInt(str) != 1 && Integer.parseInt(str) != 0) {
            Integer n = Integer.parseInt(str);

            while (!(n == 0)) {
                if (n % 2 == 1) {
                    n /= 2;
                    stack.push(1);
                } else if (n % 2 == 0) {
                    n /= 2;
                    stack.push(0);
                }
            }
        } else if (Integer.parseInt(str) == 1){
            stack.push(1);
        } else {
            stack.push(0);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
