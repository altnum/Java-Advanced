import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<Character, Integer> symbols =  new TreeMap<>();

        String text = scan.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char currSymbol = text.charAt(i);

            if (!symbols.containsKey(currSymbol))
                symbols.put(currSymbol, 1);
            else {
                int currentCount = symbols.get(currSymbol);
                symbols.put(currSymbol, ++currentCount);
            }
        }

        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());

        }
    }
}
