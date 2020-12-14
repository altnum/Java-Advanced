package bakery.entities.bakedFoods;

public class Bread extends BaseFood {
    private final static double INITIAL_BREAD_PORTION = 200.0;
    public Bread(String name, double price) {
        super(name, INITIAL_BREAD_PORTION, price);
    }
}
