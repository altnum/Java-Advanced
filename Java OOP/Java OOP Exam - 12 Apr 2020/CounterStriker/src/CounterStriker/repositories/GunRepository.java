package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;

public class GunRepository<T extends Gun> implements Repository<T> {
    Collection<T> models;

    @Override
    public Collection<T> getModels() {
        return null;
    }

    @Override
    public void add(T model) {
        if (model == null)
            throw new NullPointerException(INVALID_GUN_REPOSITORY);

        models.add(model);
    }

    @Override
    public boolean remove(T model) {
        return models.remove(model);
    }

    @Override
    public T findByName(String name) {
        if (models.stream().anyMatch(g -> g.getName().equals(name))) {
            return models.stream().filter(g -> g.getName().equals(name)).collect(Collectors.toList()).get(0);
        }
        return null;
    }
}
