import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Lootbox {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> queue = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(stack::push);
        int collection = 0;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int fromBox1 = queue.peek();
            int fromBox2 = stack.pop();
            int sum = fromBox1 + fromBox2;

            if (sum % 2 == 0) {
                collection += sum;
                queue.poll();
            } else {
                queue.offer(fromBox2);
            }
        }

        if (queue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (stack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (collection >= 100) {
            System.out.println("Your loot was epic! Value: " + collection);
        } else {
            System.out.println("Your loot was poor... Value: " + collection);
        }
    }
}
