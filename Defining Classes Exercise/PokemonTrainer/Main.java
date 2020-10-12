package PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Trainer> trainers = new LinkedList<>();
        List<String> names = new ArrayList<>();

        String command = reader.readLine();

        while(!"Tournament".equals(command)) {
            String[] info = command.split("\\s+");
            if (!names.contains(info[0])) {
                Trainer trainer = new Trainer(info[0], new Pokemon(info[1], info[2], Integer.parseInt(info[3])));
                trainers.add(trainer);
                names.add(trainer.getName());
            } else {
                for (Trainer tr: trainers) {
                    if (tr.getName().equals(info[0])) {
                        Pokemon pokemon = new Pokemon(info[1], info[2], Integer.parseInt(info[3]));
                        tr.getCollectionOfPokemon().add(pokemon);
                        break;
                    }
                }
            }
            command = reader.readLine();
        }

        command = reader.readLine();

        while (!"End".equals(command)) {
            for (Trainer tr: trainers) {
                boolean has = false;
                for (Pokemon p: tr.getCollectionOfPokemon()) {
                    if (p.getElement().equals(command)) {
                        tr.setNumberOfBadges(1);
                        has = true;
                        break;
                    }
                }
                if (!has) {
                    for (Pokemon p: tr.getCollectionOfPokemon()) {
                        p.setHealth(10);
                    }
                    tr.getCollectionOfPokemon().removeIf(p -> p.getHealth() <= 0);

                }
            }
            command = reader.readLine();
        }

        trainers
                .stream()
                .sorted((l, r) -> Integer.compare(r.getNumberOfBadges(), l.getNumberOfBadges()))
                .forEach(e -> System.out.printf("%s %d %d%n", e.getName(), e.getNumberOfBadges(), e.getCollectionOfPokemon().size()));
    }
}
