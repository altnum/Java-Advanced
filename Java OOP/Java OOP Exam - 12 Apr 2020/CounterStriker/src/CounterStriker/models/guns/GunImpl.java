package CounterStriker.models.guns;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_BULLETS_COUNT;
import static CounterStriker.common.ExceptionMessages.INVALID_GUN_NAME;

public abstract class GunImpl implements Gun {
    private String name;
    private int bulletsCount;

    protected GunImpl(String name, int bulletsCount) {
        setName(name);
        setBulletsCount(bulletsCount);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new NullPointerException(INVALID_GUN_NAME);

        this.name = name;
    }

    public void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0)
            throw new IllegalArgumentException(INVALID_GUN_BULLETS_COUNT);

        this.bulletsCount = bulletsCount;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getBulletsCount() {
        return 0;
    }

    @Override
    public int fire() {
        if (this.getClass().getSimpleName().equals("Pistol")) {
            if (bulletsCount - 1 >= 0)
                return 1;
        } else if (this.getClass().getSimpleName().equals("Rifle")) {
            if (bulletsCount - 10 >= 0)
                return 10;
        }
        return 0;
    }
}
