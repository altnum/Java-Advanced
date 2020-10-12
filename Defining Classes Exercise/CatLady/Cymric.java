package CatLady;

public class Cymric extends Cat {
    private String name;
    private String type;
    private Double doub;

    public String getName() {
        return name;
    }

    public Cymric(String name, String type, Double doub) {
        super(name, type, doub);
        this.name = name;
        this.type = type;
        this.doub = doub;
    }
}
