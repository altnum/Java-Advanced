package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        setUsername(username);
        setHealth(health);
        setArmor(armor);
        setGun(gun);
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty())
            throw new NullPointerException(INVALID_PLAYER_NAME);

        this.username = username;
    }

    public void setHealth(int health) {
        if (health < 0)
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);

        this.health = health;
    }

    public void setArmor(int armor) {
        if (armor < 0)
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);

        this.armor = armor;
    }

    public void setGun(Gun gun) {
        if (gun == null)
            throw new NullPointerException(INVALID_GUN);

        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void takeDamage(int points) {
        if (armor > 0) {
            if (armor - points > 0)
                armor -= points;
            if (armor - points <= 0) {
                int arm = (armor - points) * -1;
                armor = 0;
                health -= arm;
                if (health <= 0) {
                    health = 0;
                    isAlive = false;
                }
            }
        } else if (armor == 0) {
            health -= points;
            if (health <= 0) {
                health = 0;
                isAlive = false;
            }
        }
    }
}
