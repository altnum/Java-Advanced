package CatLady;

public class Cat {
    private String name;
    private String type;
    private Double doub;

    public String getName() {
        return name;
    }

    public Cat(String name, String type, Double doub) {
        this.name = name;
        this.type = type;
        this.doub = doub;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", type, name, doub);

    }
}
