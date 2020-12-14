package bakery.entities.bakedFoods;

public class Cake extends BaseFood {
    private final static double INITIAL_BREAD_PORTION = 245.0;
    public Cake(String name, double price) {
        super(name, INITIAL_BREAD_PORTION, price);
    }
}
