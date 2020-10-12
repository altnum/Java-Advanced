package RawData;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Car {

    protected class Engine {
        private int speed;
        private int power;

        public int getPower() {
            return power;
        }

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }
    }
    protected class Cargo {
        private int cargoWeight;
        private String cargoType;

        public Cargo(int cargoWeight, String cargoType) {
            this.cargoWeight = cargoWeight;
            this.cargoType = cargoType;
        }

        public int getCargoWeight() {
            return cargoWeight;
        }

        public String getCargoType() {
            return cargoType;
        }
    }

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Map<Double, Integer> tires;

    public String getModel() {
        return model;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Map<Double, Integer> getTires() {
        return tires;
    }

    public Engine getEngine() {
        return engine;
    }

    public Car(String model, int engineSpeed, int enginePower,
               int cargoWeight, String cargoType, Map<Double, Integer> tires) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tires = new LinkedHashMap<>();

        tires.forEach((key, value) -> this.tires.put(key, value));

    }
}
