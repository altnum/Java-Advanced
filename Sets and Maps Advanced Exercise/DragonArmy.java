import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, TreeMap<String, Integer[]>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] info = scan.nextLine().split("\\s+");

            for (int j = 0; j < info.length; j++) {
                if (info[j].equals("null")) {
                    if (j == 2)
                        info[j] = "45";
                    else if (j == 3)
                        info[j] = "250";
                    else {
                        info[j] = "10";
                    }
                }
            }
            String type = info[0];
            String name = info[1];
            String dmg = info[2];
            String hp = info[3];
            String armour = info[4];

            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).putIfAbsent(name, new Integer[3]);
            dragons.get(type).get(name)[0] = Integer.parseInt(dmg);
            dragons.get(type).get(name)[1] = Integer.parseInt(hp);
            dragons.get(type).get(name)[2] = Integer.parseInt(armour);
        }

        dragons
                .entrySet()
                .forEach(e -> {
                    double avgDmg = 0;
                    double avgHp = 0;
                    double avgArm = 0;

                    for (Map.Entry<String, Integer[]> entry: e.getValue().entrySet()) {
                        avgDmg += entry.getValue()[0];
                        avgHp += entry.getValue()[1];
                        avgArm += entry.getValue()[2];
                    }
                    int size = e.getValue().size();
                    avgArm /= size;
                    avgHp /= size;
                    avgDmg /= size;

                    System.out.printf("%s::(%.2f/%.2f/%.2f)%n", e.getKey(), avgDmg, avgHp, avgArm);

                    e.getValue()
                            .entrySet()
                            .forEach(k -> {
                                System.out.println("-" + k.getKey() + " -> damage: " + k.getValue()[0] + ", health: "
                                        + k.getValue()[1] + ", armor: " + k.getValue()[2]);
                            });
                });
    }
}
