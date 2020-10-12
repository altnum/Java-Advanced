package CarSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public String getModel() {
        return model;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, -1, efficiency);
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power) {
        this(model, power, -1, "n/a");
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        if (this.displacement == -1) {
            return String.format("%s:%nPower: %d%nDisplacement: n/a%nEfficiency: %s%n", this.model, this.power, this.efficiency);
        }
        return String.format("%s:%nPower: %d%nDisplacement: %d%nEfficiency: %s%n", this.model, this.power, this.displacement, this.efficiency);
    }
}
