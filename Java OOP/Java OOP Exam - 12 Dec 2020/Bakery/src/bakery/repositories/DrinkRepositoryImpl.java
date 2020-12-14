package bakery.repositories;

import bakery.entities.drinks.BaseDrink;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class DrinkRepositoryImpl<T extends Drink> implements DrinkRepository<Drink> {
    Collection<Drink> models;

    public DrinkRepositoryImpl(Collection<Drink> models) {
        this.models = new LinkedList<>();
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        for (Drink drink :
                models) {
            if (drink.getName().equals(drinkName) && drink.getBrand().equals(drinkBrand)) {
                return drink;
            }
        }

        return null;
    }

    @Override
    public Collection<Drink> getAll() {
        return models;
    }

    @Override
    public void add(Drink drink) {
        models.add(drink);
    }
}

