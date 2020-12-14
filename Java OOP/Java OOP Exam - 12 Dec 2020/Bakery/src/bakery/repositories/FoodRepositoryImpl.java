package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.FoodRepository;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class FoodRepositoryImpl<T extends BakedFood> implements FoodRepository<BakedFood> {
    Collection<BakedFood> models;

    public FoodRepositoryImpl() {
        this.models = new LinkedList<>();;
    }

    @Override
    public BakedFood getByName(String name) {
        for (BakedFood bF :
                models) {
            if (bF.getName().equals(name)) {
                return bF;
            }
        }
        return null;
    }

    @Override
    public Collection<BakedFood> getAll() {
        return models;
    }

    @Override
    public void add(BakedFood bakedFood) {
        models.add(bakedFood);
    }
}
