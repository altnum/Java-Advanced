package CardsWithPower;

public class Card {
    private CardRanks number;
        private CardsWithPower colour;
    private int power;

    public Card (CardRanks rank, CardsWithPower colour) {
        this.number = rank;
        this.colour = colour;
        this.power = rank.getPower() + colour.getPower();
    }

    @Override
    public String toString() {
        String cardName = this.number + " of " + this.colour;
        return String.format("CardsWithPower.Card name: %s; CardsWithPower.Card power: %d", cardName, this.power);
    }
}
