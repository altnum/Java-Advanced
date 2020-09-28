import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, String> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();

            Double[] grades = Arrays.stream(scan.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .toArray(Double[]::new);
            DecimalFormat decimal = new DecimalFormat("0.#####################");
            double avg = 0;

            for (int j = 0; j < grades.length; j++) {
                avg += grades[j];
            }
            avg /= grades.length;
            String numAvg = decimal.format(avg);
            students.put(name, numAvg);
        }

        students
                .entrySet()
                .forEach(e -> {
                    System.out.printf("%s is graduated with %s%n", e.getKey(), e.getValue());
                });
    }
}
