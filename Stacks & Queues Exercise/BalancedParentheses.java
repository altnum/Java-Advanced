import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> brackets = new LinkedHashMap<>();
        brackets.put(")", "(");
        brackets.put("]", "[");
        brackets.put("}", "{");

        ArrayDeque<String> bracketsStack = new ArrayDeque<>();

        String str = scan.nextLine();
        boolean balanced = true;

        for (int i = 0; i < str.length(); i++) {
            if (brackets.containsKey(String.valueOf(str.charAt(i)))) {
                if (!bracketsStack.isEmpty()) {
                    String symbol = bracketsStack.pop();
                    if (!symbol.equals(brackets.get(String.valueOf(str.charAt(i)))))
                        balanced = false;
                    continue;
                }
                else {
                    balanced = false;
                    break;
                }
            }
            bracketsStack.push(String.valueOf(str.charAt(i)));
        }

        if (balanced && bracketsStack.isEmpty())
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
