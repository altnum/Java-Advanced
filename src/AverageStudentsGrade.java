import java.util.*;

public class AverageStudentsGrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] info = scan.nextLine().split("\\s+");

            students.putIfAbsent(info[0], new ArrayList<>());
            students.get(info[0]).add(Double.parseDouble(info[1]));
        }

        students
                .entrySet()
                .forEach(e -> {
                    System.out.print(e.getKey() + " -> ");
                    Double avg = 0.0;
                    for (int i = 0; i < e.getValue().size(); i++) {
                        System.out.printf("%.2f ", e.getValue().get(i));
                        avg += e.getValue().get(i);
                    }
                    avg /= e.getValue().size();
                    System.out.printf("(avg: %.2f)%n", avg);
                });
    }
}
