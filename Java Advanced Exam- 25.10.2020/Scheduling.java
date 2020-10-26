import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Scheduling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(tasks::push);
        ArrayDeque<Integer> threads = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        int taskToKill = Integer.parseInt(scan.nextLine());
        int threadKiller = 0;
        int killed = -1;

        while (killed != taskToKill) {
            int firstThread = threads.peek();
            int lastTask = tasks.pop();

            if (firstThread >= lastTask) {
                threadKiller = threads.poll();
                if (lastTask == taskToKill)
                    killed = lastTask;
            } else {
                threadKiller = threads.poll();
                if (lastTask == taskToKill)
                    break;
                tasks.push(lastTask);
            }
        }

        System.out.printf("Thread with value %d killed task %d%n", threadKiller, taskToKill);
        System.out.print(threadKiller + " ");

        for (Integer n : threads) {
            System.out.print(n + " ");
        }

    }
}
