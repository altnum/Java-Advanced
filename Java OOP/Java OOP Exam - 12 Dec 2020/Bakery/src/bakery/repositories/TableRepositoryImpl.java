package bakery.repositories;

import bakery.entities.bakedFoods.Cake;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.TableRepository;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class TableRepositoryImpl<T extends Table> implements TableRepository<Table> {
    Collection<Table> models;

    public TableRepositoryImpl(Collection<Table> models) {
        this.models = new LinkedList<>();
    }

    @Override
    public Collection<Table> getAll() {
        return models;
    }

    @Override
    public void add(Table table) {
        models.add(table);
    }

    @Override
    public Table getByNumber(int number) {
        for (Table table: models) {
            if (table.getTableNumber() == number)
                return table;
        }

        return null;
    }
}
