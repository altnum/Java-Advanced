import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] children = scan.nextLine().split("\\s+");
        int toss = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < children.length; i++) {
            queue.offer(children[i]);
        }

        while (!(queue.size() == 1)) {
            for (int i = 1; i < toss; i++) {
                queue.offer(queue.poll());
            }

            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}
