package CatLady;

public class StreetExtraordinaire extends Cat {
    private String name;
    private String type;
    private Double doub;

    public String getName() {
        return name;
    }

    public StreetExtraordinaire(String name, String type, Double doub) {
        super(name, type, doub);
        this.name = name;
        this.type = type;
        this.doub = doub;
    }
}
