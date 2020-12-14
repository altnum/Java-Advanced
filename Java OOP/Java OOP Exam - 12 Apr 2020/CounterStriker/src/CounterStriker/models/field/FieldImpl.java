package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {
    List<Player> terrorists = new ArrayList<>();
    List<Player> counterTerrorists = new ArrayList<>();

    @Override
    public String start(Collection<Player> players) {
        for (Player p : players) {
            if (p.getClass().getSimpleName().equals("Terrorist"))
                terrorists.add(p);
            else
                counterTerrorists.add(p);
        }

        while (counterTerrorists.stream().anyMatch(Player::isAlive) &&
                terrorists.stream().anyMatch(Player::isAlive)) {

            terrorists.forEach(t -> counterTerrorists.forEach(cT -> cT.takeDamage(t.getGun().fire())));

            counterTerrorists = counterTerrorists.stream().filter(Player::isAlive).collect(Collectors.toList());

            if (counterTerrorists.stream().noneMatch(Player::isAlive)) {
                return TERRORIST_WINS;
            }

            counterTerrorists.forEach(cT -> terrorists.forEach(t -> t.takeDamage(cT.getGun().fire())));


            terrorists = terrorists.stream().filter(Player::isAlive).collect(Collectors.toList());

            if (terrorists.stream().noneMatch(Player::isAlive)) {
                return COUNTER_TERRORIST_WINS;
            }
        }

        if (counterTerrorists.stream().noneMatch(Player::isAlive))
            return TERRORIST_WINS;
        else if (terrorists.stream().anyMatch(Player::isAlive))
            return COUNTER_TERRORIST_WINS;


        return null;
    }
}
