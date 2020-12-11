package easterRaces.repositories;

import easterRaces.entities.cars.Car;
import easterRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;

public class CarRepository<T extends Car> implements Repository<T> {
    private Collection<T> Models = new LinkedHashSet<>();;

    @Override
    public T getByName(String name) {
        for (T t : Models) {
            if (t.getModel().equals(name))
                return t;
        }

        return null;
    }

    @Override
    public Collection<T> getAll() {
        return Models;
    }

    @Override
    public void add(T model) {
        Models.add(model);
    }

    @Override
    public boolean remove(T model) {
        return false;
    }
}
