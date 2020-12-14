package bakery.repositories.interfaces;

import bakery.entities.drinks.BaseDrink;
import bakery.entities.drinks.interfaces.Drink;

public interface DrinkRepository<T extends Drink> extends Repository<T> {
    T getByNameAndBrand(String drinkName,String drinkBrand);
}
