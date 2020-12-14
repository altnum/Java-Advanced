package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;
import CounterStriker.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;

public class ControllerImpl implements Controller {
    private Repository<Gun> gunRepository;
    private Repository<Player> playerRepository;
    private Field field;

    public ControllerImpl() {
        gunRepository = new GunRepository<>();
        playerRepository = new PlayerRepository<>();
        field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun;

        switch (type) {
            case "Pistol":
                gun = new Pistol(name, bulletsCount);
                break;
            case "Rifle":
                gun = new Rifle(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }

        gunRepository.add(gun);

        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Player player = null;

        switch (type) {
            case "Terrorist":
                Gun gun = gunRepository.findByName(gunName);
                if (gun == null)
                    throw new NullPointerException(GUN_CANNOT_BE_FOUND);

                player = new Terrorist(username, health, armor, gun);
                break;
            case "CounterTerrorist":
                Gun gun1 = gunRepository.findByName(gunName);
                if (gun1 == null)
                    throw new NullPointerException(GUN_CANNOT_BE_FOUND);

                player = new CounterTerrorist(username, health, armor, gun1);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        playerRepository.add(player);

        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return field.start(playerRepository.getModels().stream().filter(Player::isAlive).collect(Collectors.toList()));
    }

    @Override
    public String report() {
        List<Player> players = playerRepository.getModels().stream().sorted((l, r) -> {
            int res = l.getClass().getSimpleName().compareTo(r.getClass().getSimpleName());

            if (res == 0) {
                res = Integer.compare(r.getHealth(), l.getHealth());
            }
            if (res == 0)
                res = l.getUsername().compareTo(r.getUsername());

            return res;
        }).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        for (Player p : players) {
            sb.append(p.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
