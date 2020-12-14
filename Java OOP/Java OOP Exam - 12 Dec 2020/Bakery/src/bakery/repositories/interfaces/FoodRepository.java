package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.BaseFood;
import bakery.entities.bakedFoods.interfaces.BakedFood;

public interface FoodRepository<T extends BakedFood> extends Repository<T> {
    T getByName(String name);
}
