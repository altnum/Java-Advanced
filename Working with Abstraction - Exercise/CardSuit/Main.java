package CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("CardsWithPower.Card Suits:");
        for (CardSuit c :
                CardSuit.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", c.ordinal(), c);
        }
    }
}
