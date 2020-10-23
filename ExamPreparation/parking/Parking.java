package ExamPreparation.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > this.data.size())
            this.data.add(car);
    }

    public boolean remove(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car res = null;
        for (Car car : data) {
            if (res == null || res.getYear() < car.getYear()) {
                res = car;
            }
        }
        return res;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
       return this.data.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder();

        out.append(String.format("The cars are parked in %s:%n", this.type));
        for (Car car: this.data) {
            out.append(car.toString()).append(System.lineSeparator());
        }

        return  out.toString().trim();
    }
}
