package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distance = 0;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
    }

    public void setDistance(int distance) {
        this.distance +=  distance;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public int getDistance() {
        return distance;
    }

    public void setFuelAmount(int distance) {
        this.fuelAmount -= distance * fuelCost;
    }

    public boolean CanTravel(int distance) {
        if (this.fuelAmount - distance * this.fuelCost < 0) {
            System.out.println("Insufficient fuel for the drive");
            return false;
        }
        else
            return true;
   }
}
