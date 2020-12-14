package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.setTableNumber(tableNumber);
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.foodOrders = new LinkedList<>();
        this.drinkOrders = new LinkedList<>();
        this.isReserved = false;
        this.price = 0.0;
    }

    @Override
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }

        this.numberOfPeople = numberOfPeople;
    }

    public Collection<BakedFood> getFoodOrders() {
        return foodOrders;
    }

    public void setFoodOrders(Collection<BakedFood> foodOrders) {
        this.foodOrders = foodOrders;
    }

    public Collection<Drink> getDrinkOrders() {
        return drinkOrders;
    }

    public void setDrinkOrders(Collection<Drink> drinkOrders) {
        this.drinkOrders = drinkOrders;
    }

    @Override
    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }

        this.capacity = capacity;
    }

    @Override
    public double getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BaseTable{";
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.setReserved(true);
        this.setNumberOfPeople(numberOfPeople);
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double sum = 0;

        if (this.isReserved) {
            sum += this.getPrice() * this.numberOfPeople;

            for (BakedFood bF : this.foodOrders) {
                sum += bF.getPrice();
            }

            for (Drink drink : this.drinkOrders) {
                sum += drink.getPrice();
            }
        }

        return sum;
    }

    @Override
    public void clear() {
        this.foodOrders.clear();
        this.drinkOrders.clear();
        this.setReserved(false);
        this.numberOfPeople = 0;
        this.price = 0.0;
    }

    @Override
    public String getFreeTableInfo() {
        StringBuilder sb = new StringBuilder("Table: " + this.tableNumber);
        sb.append(System.lineSeparator());
        sb.append("Type: ").append(this.getClass().getSimpleName());
        sb.append(System.lineSeparator());
        sb.append("Capacity: ").append(this.capacity);
        sb.append(System.lineSeparator());
        sb.append(String.format("Price per Person: %.2f", this.pricePerPerson));

        return sb.toString();
    }
}
