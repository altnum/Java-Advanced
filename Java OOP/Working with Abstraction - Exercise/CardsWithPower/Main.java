package CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String rank = scan.readLine();
        String suit = scan.readLine();

        Card card = new Card(CardRanks.valueOf(rank), CardsWithPower.valueOf(suit));

        System.out.println(card);
    }
}
