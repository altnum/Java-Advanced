package CounterStriker.models.field;

import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

        while (true) {
            terrorists.forEach(t -> {
                int f = t.getGun().fire();
                counterTerrorists.forEach(cT -> {
                    cT.takeDamage(f);
                });
            });

            counterTerrorists.forEach(cT -> {
                int f = cT.getGun().fire();
                terrorists.forEach(t -> {
                    t.takeDamage(f);
                });
            });

            if (terrorists.stream().noneMatch(Player::isAlive)) {
                return COUNTER_TERRORIST_WINS;
            } else if (counterTerrorists.stream().noneMatch(Player::isAlive)) {
                return TERRORIST_WINS;
            }
        }
    }
}
