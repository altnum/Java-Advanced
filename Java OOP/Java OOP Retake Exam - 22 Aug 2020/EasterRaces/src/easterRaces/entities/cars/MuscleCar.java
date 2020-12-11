package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar {
    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, 5000);
    }
}
