package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_REPOSITORY;

public class PlayerRepository<T extends Player> implements Repository<T> {
    Collection<T> models;

    @Override
    public Collection<T> getModels() {
        return null;
    }

    @Override
    public void add(T model) {
        if (model == null)
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);

        models.add(model);
    }

    @Override
    public boolean remove(T model) {
        return models.remove(model);
    }

    @Override
    public T findByName(String name) {
        if (models.stream().anyMatch(p -> p.getUsername().equals(name))) {
            return models.stream().filter(p -> p.getUsername().equals(name)).collect(Collectors.toList()).get(0);
        }
        return null;
    }
}
