import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] children = scan.nextLine().split("\\s+");
        int toss = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < children.length; i++) {
            queue.offer(children[i]);
        }

        int cycle = 1;

        while (!(queue.size() == 1)) {
            for (int i = 1; i < toss; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }

            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cycle) {
        if (cycle == 1)
            return false;
        else if ((cycle > 3 && ((cycle % 2 == 0) || (cycle % 3 == 0)) || (cycle > 5 && (cycle % 5 == 0))))
            return false;
        return true;
    }
}
