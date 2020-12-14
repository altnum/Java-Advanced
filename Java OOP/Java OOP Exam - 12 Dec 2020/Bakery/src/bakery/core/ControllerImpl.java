package bakery.core;

import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import java.util.List;
import java.util.stream.Collectors;

import static bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static bakery.common.ExceptionMessages.TABLE_EXIST;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double income;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        this.income = 0.0;
    }


    @Override
    public String addFood(String type, String name, double price) {
        BakedFood bakedFood = null;

        switch (type) {
            case "Bread":
                bakedFood = new Bread(name, price);
                break;
            case "Cake":
                bakedFood = new Cake(name, price);
        }

        if (foodRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        if (bakedFood != null) {
            foodRepository.add(bakedFood);
            return String.format(FOOD_ADDED, name, type);
        }

        return null;
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drink = null;

        switch (type) {
            case "Tea":
                drink = new Tea(name, portion, brand);
                break;
            case "Water":
                drink = new Water(name, portion, brand);
        }

        if (drinkRepository.getByNameAndBrand(name, brand) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        if (drink != null) {
            drinkRepository.add(drink);
            return String.format(DRINK_ADDED, name, brand);
        }

        return null;
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;

        switch (type) {
            case "InsideTable":
                table = new InsideTable(tableNumber, capacity);
                break;
            case "OutsideTable":
                table = new OutsideTable(tableNumber, capacity);
        }

        if (tableRepository.getByNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }

        if (table != null) {
            tableRepository.add(table);
            return String.format(TABLE_ADDED, tableNumber);
        }

        return null;
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        for (Table t: tableRepository.getAll()) {
            if (!t.isReserved()) {
                if (t.getCapacity() >= numberOfPeople) {
                    t.reserve(numberOfPeople);

                    return String.format(TABLE_RESERVED, t.getTableNumber(), numberOfPeople);
                }
            }
        }

        return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        if (tableRepository.getAll().stream().filter(Table::isReserved).noneMatch(t -> t.getTableNumber() == tableNumber)) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (foodRepository.getAll().stream().noneMatch(f -> f.getName().equals(foodName))) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }

        tableRepository.getByNumber(tableNumber).orderFood(foodRepository.getByName(foodName));

        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        if (tableRepository.getAll().stream().noneMatch(t -> t.getTableNumber() == tableNumber)) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (drinkRepository.getByNameAndBrand(drinkName, drinkBrand) == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }

        tableRepository.getByNumber(tableNumber).orderDrink(drinkRepository.getByNameAndBrand(drinkName, drinkBrand));

        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);
    }

    @Override
    public String leaveTable(int tableNumber) {
        if (tableRepository.getByNumber(tableNumber) != null) {
            double sum = tableRepository.getByNumber(tableNumber).getBill() + tableRepository.getByNumber(tableNumber).getNumberOfPeople() *
                    tableRepository.getByNumber(tableNumber).getPricePerPerson();
            tableRepository.getByNumber(tableNumber).clear();
            String sumStr = String.format("%.2f", sum);
            String str = String.format(BILL, tableNumber, sum);
            income += Double.parseDouble(sumStr);
            return str;
        }

        return null;
    }

    @Override
    public String getFreeTablesInfo() {
        List<Table> freeTables = tableRepository.getAll().stream().filter(t -> !t.isReserved()).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();

        for (Table table : freeTables) {
            sb.append(table.getFreeTableInfo());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME, income);
    }
}
