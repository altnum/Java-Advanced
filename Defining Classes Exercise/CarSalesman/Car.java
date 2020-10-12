package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, -1, color);
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine) {
        this(model, engine, -1, "n/a");
    }

    @Override
    public String toString() {
        if (this.weight == -1) {
            return String.format("%s:%n%sWeight: n/a%nColor: %s", this.model, this.engine.toString(), this.color);
        }
        return String.format("%s:%n%sWeight: %d%nColor: %s", this.model, this.engine.toString(), this.weight, this.color);
    }
}
