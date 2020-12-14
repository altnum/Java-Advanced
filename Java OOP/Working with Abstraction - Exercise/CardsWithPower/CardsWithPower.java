package CardsWithPower;

public enum CardsWithPower {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int power;

    CardsWithPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }
}
