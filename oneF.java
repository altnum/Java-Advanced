import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class one {
    public static void main(String []args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        Pattern pattern = Pattern.compile("([\\|#])(?<itemName>[A-Za-z]+\\s?[A-Za-z]+)\\1(?<date>([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{2})\\1(?<calories>\\b([0-9]|[1-8][0-9]|9[0-9]|[1-8][0-9]{2}|9[0-8][0-9]|99[0-9]|[1-8][0-9]{3}|9[0-8][0-9]{2}|99[0-8][0-9]|999[0-9]|10000)\\b)\\1");
        Matcher matcher = pattern.matcher(str);
        List<String> food = new LinkedList<>();
        int calories = 0;

        while (matcher.find()) {
            food.add(matcher.group("itemName") + "#" + matcher.group("date") + "#" + matcher.group("calories"));

            calories += Integer.parseInt(matcher.group("calories"));
        }

        System.out.println(String.format("You have food to last you for: %d days!", calories / 2000));
        if (calories / 2000 != 0) {
            food
                    .forEach(e ->  {
                        String[] info = e.split("#");
                        System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n", info[0], info[1], Integer.parseInt(info[2]));
                    });
        }
    }
}
