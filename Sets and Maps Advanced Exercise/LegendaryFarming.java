import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("motes", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("shards", 0);

        Map<String, Integer> junk = new TreeMap<>();
        AtomicReference<String> obtained = new AtomicReference<>("");

        while (!keyMaterials.containsValue(250)) {
            String[] materials = scan.nextLine().split("\\s+");
            AtomicBoolean br = new AtomicBoolean(false);

            for (int i = 1; i <= materials.length - 1; i += 2) {
                String name = materials[i].toLowerCase();

                if (keyMaterials.containsKey(name)) {

                    int curr = keyMaterials.get(name);
                    keyMaterials.put(name, curr + Integer.parseInt(materials[i - 1]));
                    keyMaterials.values()
                            .forEach(v -> {
                                if (v >= 250) {
                                    br.set(true);
                                    obtained.set(name);
                                }

                            });
                    if (br.get()) {
                        int current = keyMaterials.get(obtained.toString());
                        keyMaterials.put(obtained.toString(), current - 250);
                        break;
                    }
                } else {
                    junk.putIfAbsent(name, 0);
                    int curr = junk.get(name);
                    junk.put(name, curr + Integer.parseInt(materials[i - 1]));
                }
                if (br.get())
                    break;
            }
            if (br.get())
                break;
        }
        if ("shards".equals(obtained.toString())) {
            System.out.println("Shadowmourne obtained!");
        } else if ("fragments".equals(obtained.toString())) {
            System.out.println("Valanyr obtained!");
        } else if ("motes".equals(obtained.toString())) {
            System.out.println("Dragonwrath obtained!");
        }
        keyMaterials.entrySet()
                .stream()
                .sorted((l, r) -> {
                    int result = Integer.compare(r.getValue(), l.getValue());

                    if (result == 0)
                        return l.getKey().compareTo(r.getKey());
                    return result;
                })
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        junk.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
