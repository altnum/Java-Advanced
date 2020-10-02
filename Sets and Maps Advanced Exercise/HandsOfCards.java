import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(.+):\\s(?<cards>\\s?[A-Z0-9]+,?[^\\n]+)");
        String command = scan.nextLine();
        Map<String, List<String>> players = new LinkedHashMap<>();
        Map<String, Integer> powersAndTypes = new HashMap<>();
        for (int i = 2; i < 11; i++) {
            powersAndTypes.put(String.valueOf(i), i);
        }
        powersAndTypes.put("0", 10);
        powersAndTypes.put("J", 11);
        powersAndTypes.put("Q", 12);
        powersAndTypes.put("K", 13);
        powersAndTypes.put("A", 14);
        powersAndTypes.put("S", 4);
        powersAndTypes.put("C", 1);
        powersAndTypes.put("H", 3);
        powersAndTypes.put("D", 2);

        while (!"JOKER".equals(command)) {
            Matcher matcher = pattern.matcher(command);
            String name = "";
            List<String> cards = new ArrayList<>();

            while (matcher.find()) {
                name = matcher.group(1);
                cards = Arrays.stream(matcher.group("cards").split(", ")).collect(Collectors.toList());
            }

            players.putIfAbsent(name, new ArrayList<>());

            for (int i = 0; i < cards.size(); i++) {
                if (!players.get(name).contains(cards.get(i))) {
                    players.get(name).add(cards.get(i));
                }
            }

            command = scan.nextLine();
        }

        Pattern pattern1 = Pattern.compile("([0-9*JQKA])([SDCH])");

        players
                .entrySet()
                .forEach(e -> {
                    int score = 0;
                    for (String card: e.getValue()) {
                        Matcher matcher = pattern1.matcher(card);
                                while (matcher.find()) {
                                    Integer power = powersAndTypes.get(matcher.group(1));
                                    Integer type = powersAndTypes.get(matcher.group(2));
                                    score += power * type;
                                }
                    }
                    System.out.printf("%s: %d%n", e.getKey(), score);


                });
    }
}
