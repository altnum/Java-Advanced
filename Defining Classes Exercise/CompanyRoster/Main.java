package CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Employee>> departments = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] info = scan.nextLine().split("\\s+");
            Employee employee = new Employee();
            boolean justWithEmail = false;

            if (info.length == 4) {
                employee = new Employee(info[0], Double.parseDouble(info[1]), info[2], info[3]);
            } else if (info.length == 5) {
                try {
                    employee = new Employee(info[0], Double.parseDouble(info[1]), info[2], info[3], Integer.parseInt(info[4]));
                } catch (Exception e) {
                    justWithEmail = true;
                }

                if (justWithEmail) {
                    employee = new Employee(info[0], Double.parseDouble(info[1]), info[2], info[3], info[4]);
                }
            } else if (info.length == 6) {
                employee = new Employee(info[0], Double.parseDouble(info[1]), info[2], info[3], info[4], Integer.parseInt(info[5]));
            }

            departments.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            departments.get(employee.getDepartment()).add(employee);
        }

        departments = departments.entrySet()
                .stream()
                .sorted((l, r) -> {
                    double averageL = l.getValue().stream().mapToDouble(Employee::getSalary).sum();
                    averageL /= l.getValue().size();
                    double averageR = r.getValue().stream().mapToDouble(Employee::getSalary).sum();
                    averageR /= r.getValue().size();

                    return Double.compare(averageR, averageL);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, c) -> o, LinkedHashMap::new));
        departments.forEach((key, value) -> value.sort((l, r) -> Double.compare(r.getSalary(), l.getSalary())));

        Map.Entry<String, List<Employee>> entry = departments.entrySet().iterator().next();
        System.out.println("Highest Average Salary: " + entry.getKey());
        entry.getValue().forEach(e -> System.out.printf("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));
    }
}
