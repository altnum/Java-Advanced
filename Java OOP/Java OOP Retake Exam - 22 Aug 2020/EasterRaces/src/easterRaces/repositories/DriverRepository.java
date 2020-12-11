package easterRaces.repositories;

import easterRaces.entities.drivers.Driver;
import easterRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;

public class DriverRepository<T extends Driver> implements Repository<T> {
    private Collection<T> Models = new LinkedHashSet<>();

    @Override
    public T getByName(String name) {
        for (T t : Models) {
            if (t.getName().equals(name))
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
