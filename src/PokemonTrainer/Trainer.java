package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> collectionOfPokemon;

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges += numberOfBadges;
    }

    public List<Pokemon> getCollectionOfPokemon() {
        return collectionOfPokemon;
    }

    public String getName() {
        return name;
    }

    public Trainer(String name, Pokemon pokemon) {
        this.name = name;
        this.numberOfBadges = 0;
        this.collectionOfPokemon = new ArrayList<>();
        this.collectionOfPokemon.add(pokemon);
    }
}
